package com.hexaware.dao;
import java.sql.SQLException;

import com.hexaware.entity.artwork;
import com.hexaware.exceptions.ArtWorkNotFoundException;

public interface artworkdao {

	public void Addartwork(artwork art) throws SQLException;
	public void UpdateArtworkDetails(String column,String newvalue,int ArtistID) throws SQLException, ArtWorkNotFoundException;
	public void deleteArtwork(String Column,String newvalue) throws SQLException, ArtWorkNotFoundException;
	public void showArtworks() throws SQLException;
	
	
}
