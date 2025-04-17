package com.hexaware.task2;
import java.util.Scanner;
public class NestedConditions {
	
	public static void main(String[]args) {
		
		int balance=0;
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("-----Atm-----");
		System.out.println("1.Check balance\n2.withdraw\n3.deposit\n4.exit");
		System.out.println("enter the option to choose: ");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("The balance is: "+balance);
			break;
		case 2:
			System.out.println("Enter the amount to withdraw: ");
			int amount=sc.nextInt();
			sc.nextLine();
			if(amount>balance) {
				System.out.println("Insufficient funds");
			}
			else{
				balance-=amount;
				System.out.println("The amount withdrawn is :"+amount);
			}
			break;
		case 3:
			System.out.println("Enter the deposit amount:" );
			int deposit=sc.nextInt();
			sc.nextLine();
			balance+=deposit;
			System.out.println("the amount "+deposit+" is added. your total balance: "+balance);
			break;
		case 4:
			System.out.println("thank you exiting...");
			return;
		default:
			System.out.println("Invalid Choice");
			
		}
		sc.close();
		}
		
		
		
		
	}

}
