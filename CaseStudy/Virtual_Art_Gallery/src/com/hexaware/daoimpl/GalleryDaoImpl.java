package com.hexaware.daoimpl;
import com.hexaware.util.DatabaseConnection;
import java.sql.*;

import com.hexaware.dao.gallerydao;
import com.hexaware.entity.gallery;

public class GalleryDaoImpl implements gallerydao {
	Connection conn=DatabaseConnection.getconnection("db.properties");

    public void addGallery(gallery g) {
        try{
            String query = "INSERT INTO gallery (Name, Description, Location, Curator, OpeningHours) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, g.getName());
            ps.setString(2, g.getDescription());
            ps.setString(3, g.getLocation());
            ps.setInt(4, g.getCurator());
            ps.setString(5, g.getOpeningTime());
            ps.executeUpdate();
            System.out.println("Gallery added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGallery(String columnName, String newValue, String conditionColumn, String conditionValue) {
    	
        try{
            String query = "UPDATE gallery SET " + columnName + " = ? WHERE " + conditionColumn + " = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, conditionValue);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Gallery updated successfully!");
            else System.out.println("No matching gallery found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGallery(String columnName, String value) {
        try{
            String query = "DELETE FROM gallery WHERE " + columnName + " = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, value);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Gallery deleted successfully!");
            else System.out.println("No matching gallery found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void viewGalleries() throws SQLException {
		String query="select * from gallery";
		PreparedStatement ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		if(!rs.next()) {
			System.out.println("gallaries are empty");
		}
		else {
			System.out.println("Gallery ID"+rs.getInt("GalleryID")+"Gallery Name: "+rs.getString("Name")+"\nDescription: "+rs.getString("Description")+"\nLocation: "+rs.getString("Location")+"\nCurator: "+rs.getString("Curator")+
					"\nOpeningHours: "+rs.getString("OpeningHours"));
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println("Gallery ID"+rs.getInt("GalleryID")+"Gallery Name: "+rs.getString("Name")+"\nDescription: "+rs.getString("Description")+"\nLocation: "+rs.getString("Location")+"\nCurator: "+rs.getString("Curator")+
					"\nOpeningHours: "+rs.getString("OpeningHours"));
				System.out.println("**************************************************************");
			}
		}
			
		
    }
}


