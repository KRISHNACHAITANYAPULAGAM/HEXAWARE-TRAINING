package com.hexaware.entity;

public class gallery {
	private int GalleryID;
	private String name;
	private String Description;
	private String Location;
	private int Curator;
	private String OpeningTime;

	public gallery() {
		
	}

	public int getGalleryID() {
		return GalleryID;
	}

	public void setGalleryID(int galleryID) {
		this.GalleryID = galleryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		this.Location = location;
	}

	public int getCurator() {
		return Curator;
	}

	public void setCurator(int curator) {
		this.Curator = curator;
	}

	public String getOpeningTime() {
		return OpeningTime;
	}

	public void setOpeningTime(String openingTime) {
		this.OpeningTime = openingTime;
	}
	
	
}
