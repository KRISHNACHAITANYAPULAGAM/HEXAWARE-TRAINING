package com.hexaware.entity;

public class user_favorite_artwork {

	private int UserID;
	private int ArtworkID;
	
	public user_favorite_artwork() {
		
	}
	public void setUserID(int userid) {
		this.UserID=userid;
	}
	public int getUserID() {
		return UserID;
	}
	public void setArtworkID(int artworkid) {
		this.ArtworkID=artworkid;
	}
	public int getArtworkID() {
		return ArtworkID;
	}
}

