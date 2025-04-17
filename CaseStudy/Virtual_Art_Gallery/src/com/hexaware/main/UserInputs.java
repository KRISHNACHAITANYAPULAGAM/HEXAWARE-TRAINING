package com.hexaware.main;

import java.sql.SQLException;
import java.util.*;

import com.hexaware.dao.ArtistDao;
import com.hexaware.dao.UserFavoriteArtworkDao;
import com.hexaware.dao.artworkdao;
import com.hexaware.dao.gallerydao;
import com.hexaware.dao.userdao;
import com.hexaware.entity.Artist;
import com.hexaware.entity.artwork;
import com.hexaware.entity.gallery;
import com.hexaware.entity.user;
import com.hexaware.exceptions.ArtWorkNotFoundException;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.UserNotFoundException;
import com.hexaware.exceptions.ValueNotFoundException;

public class UserInputs {
	
	public static void manageUsers(Scanner sc,userdao userDao) throws SQLException,IncorrectDetailException, ValueNotFoundException,UserNotFoundException,NumberFormatException{
		System.out.println("*****USER*****");
		System.out.println("1.Add USER");
		System.out.println("2.Update USER");
		System.out.println("3.Delete USER");
		System.out.println("4.View USERS");
		System.out.println("5.Exit");
		user us=new user();
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			try {
			System.out.println("Enter Username: ");
			us.setUserName(sc.nextLine());
			System.out.println("Enter Password: ");
			us.setPassword(sc.nextLine());
			System.out.println("Enter Email: ");
			us.setEmail(sc.nextLine());
			System.out.println("Enter First Name: ");
			us.setFirstName(sc.nextLine());
			System.out.println("Enter Last Name: ");
			us.setLastName(sc.nextLine());
			System.out.println("Enter Date of Birth (yyyy-mm-dd): ");
			us.setDateOfBirth(sc.nextLine());
			System.out.println("Enter Profile Picture URL or path: ");
			us.setProfilePicture(sc.nextLine());
			userDao.AddUser(us);
			break;}
			catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());	
			}
		case 2:
			System.out.println("enter the column you want to change: ");
			String col=sc.nextLine();
			System.out.println("enter the new Value: ");
			String newvalue=sc.nextLine();
			System.out.println("Enter the Id of User: ");
			int id=sc.nextInt();
			sc.nextLine();
			userDao.UpdateUser(col,newvalue,id);
			break;
		case 3:
			System.out.println("Enter the Column of data you know: ");
			String colo=sc.nextLine();
			System.out.println("Enter the value: ");
			String Id=sc.nextLine();
			try {
			userDao.DeleteUser(colo, Id);}
			catch(ValueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				userDao.ViewUsers();
			}catch(ValueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Exiting out");
			return;
			
		default:
			System.out.println("Option Not Found Choose the correct one");
			
		}
}
			


	public static void manageGallaries(Scanner sc, gallerydao gallaryDao) throws SQLException {
	// TODO Auto-generated method stub
		System.out.println("*****Gallery*****");
		System.out.println("1.Add Gallery");
		System.out.println("2.Update Gallery");
		System.out.println("3.Delete Gallery");
		System.out.println("4.View Galleries");
		System.out.println("5.Exit");

		int gChoice = sc.nextInt();
		sc.nextLine(); 
		switch (gChoice) {
		case 1:
		System.out.println("Enter the Gallary Details");
		System.out.print("Name: ");
		String name=sc.nextLine();
		System.out.print("Description: ");
		String des=sc.nextLine();
		System.out.print("Location: ");
		String loc=sc.nextLine();
		System.out.print("Curator: ");
		int cur=sc.nextInt();
		System.out.print("Opening Time (HH:mm:ss): ");
		String openingtime=sc.nextLine();
		
		gallery g = new gallery();
		g.setName(name);
		g.setDescription(des);
		g.setLocation(loc);
		g.setCurator(cur);
		g.setOpeningTime(openingtime);
		gallaryDao.addGallery(g);
		break;

		case 2:
		System.out.print("Column to update: ");
		String col = sc.nextLine();
		System.out.print("New value: ");
		String newVal = sc.nextLine();
		System.out.print("Condition column: ");
		String condCol = sc.nextLine();
		System.out.print("Condition value: ");
		String condVal = sc.nextLine();
		gallaryDao.updateGallery(col, newVal, condCol, condVal);
		break;

		case 3:
		System.out.print("Column to delete by: ");
		String delCol = sc.nextLine();
		System.out.print("Value: ");
		String delVal = sc.nextLine();
		gallaryDao.deleteGallery(delCol, delVal);
		break;

		case 4:
		gallaryDao.viewGalleries();
		break;

		case 5:
		return; 
		
		default:
			System.out.println("Invalid Option Choose again");

		 }
	}

	


	public static void manageArtworks(Scanner sc, artworkdao artworkDao) throws SQLException,ArtWorkNotFoundException {
	// TODO Auto-generated method stub
		System.out.println("******ArtWork******");
		System.out.println("1.Add Artwork\n2.Update Artwork\n3.Delete an ArtWork\n4.View Artworks\n5.Exit");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("enter artwork details:");
			System.out.println("Enter Artwork ID:");
			int artworkid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Title of Art:");
			String title=sc.nextLine();
			System.out.println("Enter the Description fro the Art");
			String des=sc.nextLine();
			System.out.println("Enter the Date Of Creation");
			String creationdate=sc.nextLine();
			System.out.println("Enter the Medium:");
			String Medium=sc.nextLine();
			System.out.println("Enter the ImageURL:");
			String ImageURL=sc.nextLine();
			System.out.println("Enter the ArtistID:");
			int ArtistID=sc.nextInt();
			sc.nextLine();
			
			artwork art=new artwork();
			art.setartworkid(artworkid);
			art.setTitle(title);
			art.setDescription(des);
			art.setCreationdate(creationdate);
			art.setMedium(Medium);
			art.setImageURL(ImageURL);
			art.setArtistID(ArtistID);
			try {
			artworkDao.Addartwork(art);}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("Enter the Column:");
			String col=sc.nextLine();
			System.out.println("Enter the new value:");
			String newvalue=sc.nextLine();
			System.out.println("Enter the ArtworkID:");
			int artworkID=sc.nextInt();
			sc.nextLine();
			artworkDao.UpdateArtworkDetails(col, newvalue, artworkID);
			break;
		case 3:
			System.out.println("Enter the Column:");
			String column=sc.nextLine();
			System.out.println("Enter the value of row you want to delete:");
			String newValue=sc.nextLine();
			System.out.println("Enter the ArtworkID:");
			artworkDao.deleteArtwork(column, newValue);
			break;
		case 4:
			artworkDao.showArtworks();
			break;
		case 5:
			System.out.println("Exiting ");
			return;
		default:
			System.out.println("Invalid Option Try again.");
		}
}

	public static void manageArtists(Scanner sc,ArtistDao artistDao) throws SQLException, IncorrectDetailException{ 
		System.out.println("*******Artist*******");
		System.out.println("1.Add Artist\n2.Update an Artist\n3.Delete an Artist\n4.View Artists\n5.exit");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Enter Artist Details");
			System.out.println("Enter the ArtistID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the ArtistName: ");
			String Name=sc.nextLine();
			System.out.println("Enter the Artist Biography: ");
			String bio=sc.nextLine();
			System.out.println("Enter the Artist Date of Birth: ");
			String dob=sc.nextLine();
			System.out.println("Enter the Artist Nationality: ");
			String nation=sc.nextLine();
			System.out.println("Enter the Artist Website: ");
			String website=sc.nextLine();
			System.out.println("Enter the Artist ContactInfo: ");
			String contactinfo=sc.nextLine();
			
			Artist art=new Artist();
			art.setArtistID(id);
			art.setName(Name);
			art.setBiography(bio);
			art.setBirthDate(dob);
			art.setNationality(nation);
			art.setWebsite(website);
			art.setContactInformation(contactinfo);
			try {
			artistDao.addArtist(art);}
			catch(SQLException e) {
				System.out.println("caught Exception "+e.getMessage());
			}catch (IncorrectDetailException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("Select Column to Update:");
			String column=sc.nextLine();
			System.out.println("Enter a NewValue");
			String newvalue=sc.nextLine();
			System.out.println("Select the Artist ID whom you want to update: ");
			int artistid=sc.nextInt();
			artistDao.updateArtist(column, newvalue, artistid);
			break;
		case 3:
			System.out.println("select the Column you want to search: ");
			String col=sc.nextLine();
			System.out.println("select the value where you want to delete: ");
			String del=sc.nextLine();
			artistDao.deleteArtist(col, del);
			break;
		case 4:
			try {
			System.out.println("The Details of all the Artists are : ");
			artistDao.viewArtist();}
			catch(ValueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Exiting ");
			return;
		default:
			System.out.println("invalid option try again");
		}
		
	}
	public static void manageFavoriteArtworks(Scanner sc, UserFavoriteArtworkDao favDao) throws SQLException {
	    System.out.println("*******Manage Favorite Artworks*******");
	    System.out.println("1.Add Favorite Artwork\n2.Remove Favorite Artwork\n3.View Favorite Artworks\n4.Exit");
	    int choice = sc.nextInt();
	    sc.nextLine();
	    switch(choice) {
	        case 1:
	            System.out.println("Enter User Details");
	            System.out.println("Enter your User ID: ");
	            int userId = sc.nextInt();
	            sc.nextLine();
	            System.out.println("Enter Artwork ID to mark as favorite: ");
	            int artworkId = sc.nextInt();
	            sc.nextLine();

	            try {
	                boolean success = favDao.addFavoriteArtwork(userId, artworkId);
	                if (success) {
	                    System.out.println("Artwork added to your favorites successfully!");
	                } else {
	                    System.out.println("Failed to add artwork to favorites.");
	                }
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
	            break;

	        case 2:
	            System.out.println("Enter User Details");
	            System.out.println("Enter your User ID: ");
	            int userIdToRemove = sc.nextInt();
	            sc.nextLine();
	            System.out.println("Enter Artwork ID to remove from favorites: ");
	            int artworkIdToRemove = sc.nextInt();
	            sc.nextLine();

	            try {
	                boolean success = favDao.removeFavoriteArtwork(userIdToRemove, artworkIdToRemove);
	                if (success) {
	                    System.out.println("Artwork removed from your favorites successfully!");
	                } else {
	                    System.out.println("Failed to remove artwork from favorites.");
	                }
	            } catch (SQLException e) {
	                System.out.println("SQL Error: " + e.getMessage());
	            }
	            break;

	        case 3:
	            System.out.println("Enter your User ID: ");
	            int userIdToView = sc.nextInt();
	            sc.nextLine();
	            System.out.println("Enter your Username: ");
	            String username = sc.nextLine();

	            try {
	                List<String> favorites = favDao.getFavoriteArtworksByUserId(userIdToView, username);
	                if (favorites.isEmpty()) {
	                    System.out.println("No favorite artworks found for the given user.");
	                } else {
	                    System.out.println("Favorite Artworks:");
	                    for (String art : favorites) {
	                        System.out.println("- " + art);
	                    }
	                }
	            } catch (SQLException e) {
	                System.out.println("SQL Error: " + e.getMessage());
	            }
	            break;

	        case 4:
	            System.out.println("Exiting ");
	            return;

	        default:
	            System.out.println("Invalid option. Please try again.");
	    }
	}}
	
	
	


