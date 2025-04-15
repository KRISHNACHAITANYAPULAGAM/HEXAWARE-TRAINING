package Dao;

import entity.Policy;
import exception.PolicyNotFoundException;

import java.util.List;

public interface IPolicyService {
    boolean createPolicy(Policy policy);
    Policy getPolicy(int policyId) throws PolicyNotFoundException;
    List<Policy> getAllPolicies();
    boolean updatePolicy(Policy policy,String column, String newValue) throws PolicyNotFoundException;
    boolean deletePolicy(int policyId) throws PolicyNotFoundException;

}
