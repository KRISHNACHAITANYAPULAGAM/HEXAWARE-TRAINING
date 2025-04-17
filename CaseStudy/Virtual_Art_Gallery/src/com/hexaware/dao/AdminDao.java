package com.hexaware.dao;
import java.sql.SQLException;

import com.hexaware.entity.Admin;

public interface AdminDao {
	
	public boolean Validatelogin(Admin admin) throws SQLException;

}
