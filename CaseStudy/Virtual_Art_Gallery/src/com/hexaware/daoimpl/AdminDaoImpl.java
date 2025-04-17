package com.hexaware.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.dao.AdminDao;
import com.hexaware.entity.Admin;

import com.hexaware.util.DatabaseConnection;

public class AdminDaoImpl implements AdminDao{
	
	Connection conn=DatabaseConnection.getconnection("db.properties");

	@Override
	public boolean Validatelogin(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from admin where adminloginID=? and password=?";
		PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, admin.getUsername());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        return rs.next();
		
	}

}
