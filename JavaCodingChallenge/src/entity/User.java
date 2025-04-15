package entity;

public class User {
	
	private int UserId;
	private String username;
	private String password;
	private String role;
	
	public User() {}

    public User(int userId, String username, String password, String role) {
        this.UserId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		this.UserId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
