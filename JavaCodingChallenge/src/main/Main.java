package main;

import Dao.InsuranceServiceImpl;
import Dao.IPolicyService;
import exception.PolicyNotFoundException;
import entity.Policy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws PolicyNotFoundException {
        IPolicyService policyService = new InsuranceServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***Insurance Management System***");
            System.out.println("1. Add Policy\n2. View All Policies\n3. Search Policy by ID\n4. Update Policy\n5. Delete Policy\n6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Policy ID: ");
                    int policyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Policy Name: ");
                    String policyName = scanner.nextLine();
                    System.out.print("Enter Coverage Details: ");
                    String coverageDetails = scanner.nextLine();
                    System.out.print("Enter Premium Amount: ");
                    double premiumAmount = scanner.nextDouble();

                    Policy newPolicy = new Policy(policyId, policyName, coverageDetails, premiumAmount);
                    boolean isCreated = policyService.createPolicy(newPolicy);
                    if (isCreated) {
                        System.out.println("Policy added successfully.");
                    } else {
                        System.out.println("Error in adding policy.");
                    }
                    break;

                case 2:
                    List<Policy> policies = policyService.getAllPolicies();
                    for (Policy policy : policies) {
                        System.out.println("Policy ID: " + policy.getPolicyId());
                        System.out.println("Policy Name: " + policy.getPolicyName());
                        System.out.println("Coverage: " + policy.getCoverageDetails());
                        System.out.println("Premium: " + policy.getPremiumAmount());
                        System.out.println("-----------------------------");
                    }
                    break;

                case 3:
                    System.out.print("enter policy Id to view: ");
                    int viewId = scanner.nextInt();
                    try {
                        Policy policy = policyService.getPolicy(viewId);
                        System.out.println("Policy ID: " + policy.getPolicyId());
                        System.out.println("Policy Name: " + policy.getPolicyName());
                        System.out.println("Coverage: " + policy.getCoverageDetails());
                        System.out.println("Premium: " + policy.getPremiumAmount());
                    } catch (PolicyNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("enter policy ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Policy policyToUpdate = policyService.getPolicy(updateId);
                        System.out.print("Enter the column name to update (policyName, coverageDetails, premiumAmount): ");
                        String column = scanner.nextLine();
                        System.out.print("Enter the new value: ");
                        String newValue = scanner.nextLine();

                        boolean isUpdated = policyService.updatePolicy(policyToUpdate, column, newValue);
                        if (isUpdated) {
                            System.out.println("Policy updated successfully.");
                        } else {
                            System.out.println("Failed in updating policy.");
                        }
                    } catch (PolicyNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Policy id to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean isDeleted = policyService.deletePolicy(deleteId);
                    if (isDeleted) {
                        System.out.println("Policy deleted successfully.");
                    } else {
                        System.out.println("Failed to delete policy.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
