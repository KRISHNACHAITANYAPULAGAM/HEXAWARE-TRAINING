package com.hexaware.dao;
import java.sql.SQLException;

import com.hexaware.entity.user;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.UserNotFoundException;
import com.hexaware.exceptions.ValueNotFoundException;

public interface userdao {
	public void AddUser(user us) throws SQLException, IncorrectDetailException;
	public void UpdateUser(String column,String newvalue,int id) throws ValueNotFoundException, UserNotFoundException;
	public void DeleteUser(String col,String id) throws ValueNotFoundException, UserNotFoundException, NumberFormatException, SQLException;
	public void ViewUsers()throws ValueNotFoundException, SQLException;

}
