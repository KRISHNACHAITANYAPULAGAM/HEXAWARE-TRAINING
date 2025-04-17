package com.hexaware.entity;

public class Artist {
	private int ArtistID;
	private String Name;
	private String Biography;
	private String BirthDate;
	private String Nationality;
	private String Website;
	private String ContactInformation;
	
	public Artist(){
		
	}

	public int getArtistID() {
		return ArtistID;
	}

	public void setArtistID(int artistID) {
		this.ArtistID = artistID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getBiography() {
		return Biography;
	}

	public void setBiography(String biography) {
		this.Biography = biography;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		this.BirthDate = birthDate;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		this.Nationality = nationality;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		this.Website = website;
	}

	public String getContactInformation() {
		return ContactInformation;
	}

	public void setContactInformation(String contactInformation) {
		if(!(contactInformation.length()==10)) {
			System.out.println("Contact number must be 10 digits");
		}else {
		this.ContactInformation = contactInformation;
	}
	}

}
