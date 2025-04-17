package com.hexaware.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.hexaware.dao.userdao;
import com.hexaware.entity.user;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.UserNotFoundException;
import com.hexaware.exceptions.ValueNotFoundException;
import com.hexaware.util.DatabaseConnection;

public class UserDaoImpl implements userdao{
	Connection conn=DatabaseConnection.getconnection("db.properties");

	public boolean checkuser(int id) throws SQLException {
		String query="select 1  from user where UserID=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		return rs.next();
		
	}
	
	
	public void AddUser(user us) throws SQLException,IncorrectDetailException {
		// TODO Auto-generated method stub
		String query="insert into user(Username,password,Email,FirstName,LastName,DateOfBirth,ProfilePicture) values(?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
	    if (us.getUserName() == null || us.getUserName().trim().isEmpty()) {
	        throw new IncorrectDetailException("UserName can't be empty.");
	    }

	    if (us.getPassword() == null || us.getPassword().trim().isEmpty()) {
	        throw new IncorrectDetailException("Password can't be empty. Please try again.");
	    }

	    if (us.getEmail() == null || !us.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
	        throw new IncorrectDetailException("Invalid email format.");
	    }

	    if (us.getDateOfBirth() == null || !us.getDateOfBirth().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	        throw new IncorrectDetailException("Invalid DOB format. Use yyyy-MM-dd.");
	    }
		try {
			ps.setString(1, us.getUserName());
			ps.setString(2, us.getPassword());
			ps.setString(3, us.getEmail());
			ps.setString(4, us.getFirstName());
			ps.setString(5, us.getLastName());
			ps.setString(6, us.getDateOfBirth());
			ps.setString(7, us.getProfilePicture());
			int count=ps.executeUpdate();
			if(count>0) {
				System.out.println("User Added Succesfully");
			}else {
				System.out.println("Something went Wrong try again");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void UpdateUser(String column,String newvalue,int id) throws ValueNotFoundException,UserNotFoundException{
		// TODO Auto-generated method stub
		List<String> col=Arrays.asList("UserId","UserName","Password","Email","FirstName","LastName","DateOfBirth","ProfilePicture");
		if(!col.contains(column)) {
			throw new ValueNotFoundException("Column name is not available");
		}
		try {
			if(!checkuser(id)) {
				throw new UserNotFoundException("User is not in the database");
			}else {
			
		String query="update user set "+column+"=? where UserID=? ";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, newvalue);
		ps.setInt(2, id);
		int row=ps.executeUpdate();
		if(row>0) {
			System.out.println("update success");
		}}}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public void DeleteUser(String column,String id) throws ValueNotFoundException, UserNotFoundException, NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		List<String> col=Arrays.asList("UserId","UserName","Password","Email","FirstName","LastName","DateOfBirth","ProfilePicture");
		if(!col.contains(column)) {
			throw new ValueNotFoundException("No column Found");
		}
		if(column.equals("UserId")) {
		if(!checkuser(Integer.parseInt(id))) {
			throw new UserNotFoundException("User Id Not Present");
		}}
		String query="delete from user where "+column+" =?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			if(column.equalsIgnoreCase("UserID")) {
				ps.setInt(1, Integer.parseInt(id));
			}else {
				ps.setString(1, id);
			}
			ps.executeUpdate();
			System.out.println("delete Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void ViewUsers() throws ValueNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query="select * from user";
		PreparedStatement ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		if(!rs.next()) {
			throw new ValueNotFoundException("User Data is empty");
		}
		else {
			System.out.println("User ID: "+rs.getInt("UserID")+"\nName: "+rs.getString("FirstName")+rs.getString("LastName")+"\nDate of Birth: "+rs.getString("DateOFBirth"));
			System.out.println("**************************************");
			while(rs.next()) {
				System.out.println("User ID: "+rs.getInt("UserID")+"\nName: "+rs.getString("FirstName")+rs.getString("LastName")+"\nDate of Birth: "+rs.getString("DateOFBirth"));
				System.out.println("**************************************");
			}
		}
	}
	

}
