package Dao;

import entity.Policy;
import exception.PolicyNotFoundException;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsuranceServiceImpl implements IPolicyService {

    private Connection conn;

    public InsuranceServiceImpl() {
        this.conn = DBConnection.getConnection();
    }

    List<String> col=Arrays.asList("policyId", "policyName", "coverageDetails", "premiumAmount");
    public boolean createPolicy(Policy policy) {
        String query = "INSERT INTO Policy (policyId, policyName, coverageDetails, premiumAmount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, policy.getPolicyId());
            ps.setString(2, policy.getPolicyName());
            ps.setString(3, policy.getCoverageDetails());
            ps.setDouble(4, policy.getPremiumAmount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Policy getPolicy(int policyId) throws PolicyNotFoundException {
        String query = "SELECT * FROM Policy WHERE policyId = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, policyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyName"),
                    rs.getString("coverageDetails"),
                    rs.getDouble("premiumAmount")
                );
            } else {
                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Policy> getAllPolicies() {
        List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM Policy";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                policies.add(new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyName"),
                    rs.getString("coverageDetails"),
                    rs.getDouble("premiumAmount")
                ));
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return policies;
    }
    
    public boolean checkid(int id) throws SQLException {
        String query = "SELECT 1 FROM Policy WHERE policyId = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean updatePolicy(Policy policy, String column, String newValue) throws PolicyNotFoundException {
        if (!col.contains(column)) {
            System.out.println("Invalid Column Name");
            return false;
        }

        String query = "UPDATE Policy SET " + column + " = ? WHERE policyId = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            if (column.equals("policyName") || column.equals("coverageDetails")) {
                ps.setString(1, newValue);
            } else if (column.equals("premiumAmount")) {
                ps.setDouble(1, Double.parseDouble(newValue));
            }
            if(!checkid(policy.getPolicyId())) {
            	throw new PolicyNotFoundException("PolicyID not Found");
            }
            else {
            ps.setInt(2, policy.getPolicyId());
            return ps.executeUpdate() > 0;}
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public boolean deletePolicy(int policyId) throws PolicyNotFoundException {
        String query = "DELETE FROM Policy WHERE policyId=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, policyId);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
