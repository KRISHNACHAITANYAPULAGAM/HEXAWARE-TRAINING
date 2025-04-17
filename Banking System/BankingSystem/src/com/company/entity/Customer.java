package com.company.entity;


public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private long phoneNumber;
    private String address;
    private String joiningDate;

    // Constructor with parameters for initialization
    public Customer(int customerId, String firstName, String lastName, String dob2, String email, long phoneNumber, String address, String joiningDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob2;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.joiningDate = joiningDate;
    }

    // Getters and setters for each attribute
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    @Override
    public String toString() {
        return "Customer ID: " + customerId +
               ", Name: " + firstName + " " + lastName +
               ", DOB: " + dob +
               ", Email: " + email +
               ", Phone: " + phoneNumber +
               ", Address: " + address +
               ", Joining Date: " + joiningDate;
    }

}
