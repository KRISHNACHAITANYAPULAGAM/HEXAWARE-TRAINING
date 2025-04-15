package entity;

public class Policy {
    private int policyId;
    private String policyName;
    private String coverageDetails;
    private double premiumAmount;

    public Policy() {}

    public Policy(int policyId, String policyName, String coverageDetails, double premiumAmount) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.coverageDetails = coverageDetails;
        this.premiumAmount = premiumAmount;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    // To print all variable values
    public String toString() {
        return "Policy [policyId=" + policyId + ", policyName=" + policyName +
               ", coverageDetails=" + coverageDetails + ", premiumAmount=" + premiumAmount + "]";
    }


}
