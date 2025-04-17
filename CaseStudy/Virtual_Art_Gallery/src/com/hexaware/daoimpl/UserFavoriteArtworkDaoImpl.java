package com.hexaware.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.UserFavoriteArtworkDao;
import com.hexaware.util.DatabaseConnection;

public class UserFavoriteArtworkDaoImpl implements UserFavoriteArtworkDao{
	Connection conn=DatabaseConnection.getconnection("db.properties");
	
	 public List<String> getFavoriteArtworksByUserId(int userId,String Username) throws SQLException {
	        List<String> favoriteArtworks = new ArrayList<>();

	        String sql = "SELECT a.Title " +
	                     "FROM user_favorite_artwork ufa " +
	                     "JOIN artwork a ON ufa.artworkId = a.artworkId " +
	                     "JOIN user u on ufa.UserId=u.UserID "+
	                     "WHERE ufa.userid = ? and u.username=?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, userId);
	            ps.setString(2, Username);

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    favoriteArtworks.add(rs.getString("Title"));
	                }
	            }
	        }catch(SQLException e) {
	        	System.out.println(e.getMessage());
	        }

	        return favoriteArtworks;
	    }
	 
	    public boolean addFavoriteArtwork(int userId, int artworkId) throws SQLException {
	        String sql = "INSERT INTO user_favorite_artwork (userId, artworkId) VALUES (?, ?)";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, userId);
	            ps.setInt(2, artworkId);
	            int rowsInserted = ps.executeUpdate();
	            return rowsInserted > 0;
	        }
	    }

	    public boolean removeFavoriteArtwork(int userId, int artworkId) throws SQLException {
	        String sql = "DELETE FROM user_favorite_artwork WHERE userId = ? AND artworkId = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, userId);
	            ps.setInt(2, artworkId);
	            int rowsDeleted = ps.executeUpdate();
	            return rowsDeleted > 0;
	        }
	    }
}
	 
	 

