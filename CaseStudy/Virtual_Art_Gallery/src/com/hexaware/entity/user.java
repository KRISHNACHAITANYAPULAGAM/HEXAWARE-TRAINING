package com.hexaware.entity;

public class user {
	private int UserID;
	private String UserName;
	private String Password;
	private String Email;
	private String FirstName;
	private String LastName;
	private String DateOfBirth;
	private String ProfilePicture;
	
	public user() {
		
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		try {
		if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new IllegalArgumentException("Invalid email format.");
		}
		else {
		this.Email = email;}}
		catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		if (!dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			System.out.println("Error: Invalid DOB format. Please use the format yyyy-MM-dd.");
			} else {
				this.DateOfBirth = dateOfBirth;
		    }
		}

	public String getProfilePicture() {
		return ProfilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.ProfilePicture = profilePicture;
	}
	
	

}
