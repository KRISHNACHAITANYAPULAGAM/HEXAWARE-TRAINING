package com.hexaware.entity;

public class artwork {
	private int ArtworkID;
	private String Title;
	private String Description;
	private String CreationDate;
	private String Medium;
	private String ImageURL;
	private int ArtistID;
	public artwork() {
		
	}
	
	// Setters
	public void setartworkid(int ArtworkID){
		this.ArtworkID=ArtworkID;
	}
	public void setTitle(String Title) {
		this.Title=Title;
	}
	public void setDescription(String Description) {
		this.Description=Description;
	}
	public void setCreationdate(String CreationDate) {
		this.CreationDate=CreationDate;
	}
	public void setMedium(String med) {
		this.Medium=med;
	}
	public void setImageURL(String url) {
		this.ImageURL=url;
	}
	public void setArtistID(int artistid) {
		this.ArtistID=artistid;
	}
	//Getters

	public int getArtworkID() {
		return ArtworkID;
	}

	public String getCreationDate() {
		return CreationDate;
	}


	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public String getMedium() {
		return Medium;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public int getArtistID() {
		return ArtistID;
	}
	

}
