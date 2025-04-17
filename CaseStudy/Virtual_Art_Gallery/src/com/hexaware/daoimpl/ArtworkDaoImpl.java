package com.hexaware.daoimpl;

import java.util.*;

import com.hexaware.dao.artworkdao;
import com.hexaware.entity.artwork;
import com.hexaware.exceptions.ArtWorkNotFoundException;

import java.sql.SQLException;
import java.sql.Connection;
import com.hexaware.util.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ArtworkDaoImpl implements artworkdao{
	Connection conn=DatabaseConnection.getconnection("db.properties");
	
	public boolean checkint(int id) throws SQLException, ArtWorkNotFoundException{
		String query="select 1 from artwork where ArtworkID=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		return rs.next();
	}

	public void Addartwork(artwork art) throws SQLException{
		// TODO Auto-generated method stub
		String query="insert into artwork(ArtworkID,Title,Description,CreationDate,Medium,ImageURL,ArtistID) Values(?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, art.getArtworkID());
		ps.setString(2,art.getTitle());
		ps.setString(3,art.getDescription());
		ps.setString(4,art.getCreationDate());
		ps.setString(5,art.getMedium());
		ps.setString(6,art.getImageURL());
		ps.setInt(7,art.getArtistID());
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Artwork added succesfully");
		}
	}

	public void UpdateArtworkDetails(String column,String newvalue,int ArtistID)throws ArtWorkNotFoundException,SQLException {
		// TODO Auto-generated method stub
		List<String> columns=Arrays.asList("ArtworkID","Title","Description","CreationDate","Medium","ImageURL","ArtistID");
		if(!columns.contains(column)) {
			System.out.println("invalid Column name");
		}
		String query="Update artwork set "+column+" =? where ArtworkID=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,newvalue);
		ps.setInt(2, ArtistID);
		int rows=ps.executeUpdate();
		if (rows>0) {
		System.out.println("update success");}
	}
	
	public void deleteArtwork(String Column,String newvalue) throws ArtWorkNotFoundException,SQLException {
		// TODO Auto-generated method stub
		List<String> columns=Arrays.asList("ArtworkID","Title","Description","CreationDate","Medium","ImageURL","ArtistID");
		try {
		if(!columns.contains(Column)) {
		System.out.println("Column not found");
		}
		if(Column.equals("ArtworkID")) {
			int id=Integer.parseInt(newvalue);
			if(!checkint(id)) {
				throw new ArtWorkNotFoundException("ArtworkId not Found");
			}
		}
		
		String query="delete from artwork where "+Column+" = ?";
		PreparedStatement ps=conn.prepareStatement(query);
		
		if(Column.equals("ArtworkID")|| Column.equals("ArtistID")) {
			ps.setInt(1,Integer.parseInt(newvalue));
			
		}else {
			ps.setString(1, newvalue);
		}
		ps.executeUpdate();
		System.out.println("delete successfull");
	}catch(ArtWorkNotFoundException e) {
		System.out.println(e.getMessage());
	}
		
	}
		
	public void showArtworks() throws SQLException {
		// TODO Auto-generated method stub
		String query="select * from Artwork";
		PreparedStatement ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		boolean hasArtworks = false;
		while(rs.next()) {
			hasArtworks=true;
			System.out.println("ArtworkID: "+rs.getInt("ArtworkID")+"\nTitle: "+rs.getString("Title")+"\nDescription: "+rs.getString("Description")+"\nCreationDate: "+rs.getString("CreationDate")+"\nMedium: "+rs.getString("Medium")
			+"\nImageURL: "+rs.getString("ImageURL")+"\nArtistID: "+rs.getString("ArtistID"));
			System.out.println("**************************************************************");
		}
		if(!hasArtworks) {
			System.out.println("No Artworks to display");
		}

	}
	

}

