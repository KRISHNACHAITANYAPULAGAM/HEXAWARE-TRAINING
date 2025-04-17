package com.hexaware.daoimpl;
import com.hexaware.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.hexaware.dao.ArtistDao;
import com.hexaware.entity.Artist;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.ValueNotFoundException;


public class ArtistDaoImpl implements ArtistDao{
	private Connection conn=DatabaseConnection.getconnection("db.properties");
	public void addArtist(Artist artist) throws IncorrectDetailException, SQLException{
		String query="Insert into artist(ArtistID,Name,Biography,BirthDate,Nationality,Website,ContactInformation) values (?,?,?,?,?,?,?) ";
		PreparedStatement ps=conn.prepareStatement(query);
		String birthDate = artist.getBirthDate();
		if (!birthDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
		    throw new IncorrectDetailException("BirthDate must be in yyyy-mm-dd format.");
		}
		if (artist.getArtistID()<=0) {
			throw new IncorrectDetailException("ID must be possitive");
		}
		if (artist.getContactInformation() == null || artist.getContactInformation().length() != 10) {
		    throw new IncorrectDetailException("ContactInfo must be 10 digits.");
		}

		
		try {
		ps.setInt(1, artist.getArtistID());
		ps.setString(2, artist.getName());
		ps.setString(3, artist.getBiography());
		ps.setString(4, artist.getBirthDate());
		ps.setString(5,artist.getNationality());
		ps.setString(6, artist.getWebsite());
		ps.setString(7, artist.getContactInformation());
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Artist added Successfully");
		}else {
			System.out.println("adding failed");
		}}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void viewArtist() throws ValueNotFoundException{
		// TODO Auto-generated method stub
		String query="select * from artist";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(!rs.next()) {
				throw new ValueNotFoundException("No Artists To Display");
			}
			else {
				System.out.println("Name: "+rs.getString("Name")+"\nBiography: "+rs.getString("Biography")+"\nBirthDate: "+rs.getString("BirthDate")+"\nNationality: "+rs.getString("Nationality")
				+"\nWebsite: "+rs.getString("Website")+"\nContact Info: "+rs.getString("ContactInformation"));
				System.out.println("************************************************************");
				while(rs.next()) {
					System.out.println("Name: "+rs.getString("Name")+"\nBiography: "+rs.getString("Biography")+"\nBirthDate: "+rs.getString("BirthDate")+"\nNationality: "+rs.getString("Nationality")
					+"\nWebsite: "+rs.getString("Website")+"\nContact Info: "+rs.getString("ContactInformation"));
					System.out.println("************************************************************");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void updateArtist(String column,String newvalue,int ArtistID) throws SQLException{
		// TODO Auto-generated method stub
		
		List<String> columns=Arrays.asList("ArtistID","Name","Biography","BirthDate","Nationality","Website","ContactInformation");
		if(!columns.contains(column)) {
			System.out.println("invalid Column");
		}
		String query="Update artist set "+column+" =? where ArtistID=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,newvalue);
		ps.setInt(2, ArtistID);
		int rows=ps.executeUpdate();
		if (rows>0) {
		System.out.println("update success");}
	}

	public void deleteArtist(String Column,String newvalue) throws SQLException{
		// TODO Auto-generated method stub
		List<String> columns=Arrays.asList("ArtistID","Name","Biography","BirthDate","Nationality","Website","ContactInformation");
		if(!columns.contains(Column)) {
		System.out.println("Column not found");
		}
		
		String query="delete from artist where "+Column+" = ?";
		PreparedStatement ps=conn.prepareStatement(query);
		if(Column.equals("ArtistID")) {
			ps.setInt(1,Integer.parseInt(newvalue));
		}else {
			ps.setString(1, newvalue);
		}
		ps.executeUpdate();
		System.out.println("delete successfull");
	}
	
}
