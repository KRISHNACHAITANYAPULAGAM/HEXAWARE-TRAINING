package com.hexaware.dao;
import java.sql.SQLException;

import com.hexaware.entity.Artist;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.ValueNotFoundException;

public interface ArtistDao {
	public void addArtist(Artist artist) throws SQLException, IncorrectDetailException;
	public void viewArtist() throws ValueNotFoundException;
	public void updateArtist(String column,String newvalue,int ArtistID) throws SQLException;
	public void deleteArtist(String Column,String newvalue)throws SQLException;

	
}
