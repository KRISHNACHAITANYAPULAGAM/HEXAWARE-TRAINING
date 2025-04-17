package com.hexaware.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.dao.AdminDao;
import com.hexaware.dao.ArtistDao;
import com.hexaware.dao.UserFavoriteArtworkDao;
import com.hexaware.dao.artworkdao;
import com.hexaware.dao.gallerydao;
import com.hexaware.dao.userdao;
import com.hexaware.daoimpl.AdminDaoImpl;
import com.hexaware.daoimpl.ArtistDaoImpl;
import com.hexaware.daoimpl.ArtworkDaoImpl;
import com.hexaware.daoimpl.GalleryDaoImpl;
import com.hexaware.daoimpl.UserDaoImpl;
import com.hexaware.daoimpl.UserFavoriteArtworkDaoImpl;
import com.hexaware.entity.Admin;
import com.hexaware.exceptions.ArtWorkNotFoundException;
import com.hexaware.exceptions.IncorrectDetailException;
import com.hexaware.exceptions.UserNotFoundException;
import com.hexaware.exceptions.ValueNotFoundException;


public class Main extends UserInputs{
	public static void main(String[]args) throws SQLException, IncorrectDetailException, ValueNotFoundException, ArtWorkNotFoundException,UserNotFoundException {
		int choice;
		AdminDao adminDao=new AdminDaoImpl();
		ArtistDao artistDao = new ArtistDaoImpl();
        artworkdao artworkDao = new ArtworkDaoImpl();
        gallerydao gallaryDao=new GalleryDaoImpl();
        userdao userDao=new UserDaoImpl();
        UserFavoriteArtworkDao favDao = new UserFavoriteArtworkDaoImpl();
        
		Scanner sc=new Scanner(System.in);
		mainloop:
		while(true) {
		System.out.println("Choose the Role: ");
		System.out.println("1.Admin\n2.User\n3.Exit");
		int role=sc.nextInt();
		sc.nextLine();
		switch(role) {
		case 1:
			System.out.println("Enter the Admin Login Credentials: ");
			System.out.println("Enter the Username: ");
			String username=sc.nextLine();
			System.out.println("Enter the Password: ");
			String password=sc.nextLine();
			Admin Admin=new Admin(username,password);

			if(adminDao.Validatelogin(Admin)) {
				System.out.println("****Access granted*****");
				System.out.println("\n");
			while(true) {
			System.out.println("*****Vitual Art Gallery*****");
			System.out.println("1.Manage Artists\n2.Manage Artworks\n3.Manage Gallaries\n4.Manage Users\n5.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				try {
					manageArtists(sc, artistDao);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IncorrectDetailException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				manageArtworks(sc,artworkDao);
				break;
			case 3:
				manageGallaries(sc,gallaryDao);
				break;
			case 4:
				try {
					manageUsers(sc,userDao);
				}catch (UserNotFoundException | ValueNotFoundException | IncorrectDetailException e) {
			        System.out.println("Error: " + e.getMessage());} 
				catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 5:
				System.out.println("ThankYou Exiting...");
				continue mainloop;
			default:
				System.out.println("Invalid choice");
			}}}
			else {
				System.out.println("Access Denied....");
			}
		case 2:
		    while (true) {
		        System.out.println("*****Virtual Art Gallery - User View*****");
		        System.out.println("1. View Artists\n2. View Artworks\n3. View Galleries\n4. View Users\n5. Manage Favorite ArtWorks\n6. Exit");
		        int userChoice = sc.nextInt();
		        sc.nextLine();
		        switch (userChoice) {
		            case 1:
		                try {
		                    artistDao.viewArtist();
		                } catch (ValueNotFoundException e) {
		                    System.out.println(e.getMessage());
		                }
		                break;
		            case 2:
		                try {
		                    artworkDao.showArtworks();
		                } catch (SQLException e) {
		                    System.out.println(e.getMessage());
		                }
		                break;
		            case 3:
		                try {
		                    gallaryDao.viewGalleries();
		                } catch (SQLException e) {
		                    System.out.println(e.getMessage());
		                }
		                break;
		            case 4:
		                try {
		                    userDao.ViewUsers();
		                } catch (ValueNotFoundException | SQLException e) {
		                    System.out.println(e.getMessage());
		                }
		                break;
		            case 5:
		            	try {
		            		manageFavoriteArtworks(sc, favDao);  // Calling the method from UserInputs
                            break;
		            	}catch(SQLException e) {
		            		System.out.println(e.getMessage());
		            	}
		            	
		            	
		            case 6:
		                System.out.println("Thank you! Visit Again...");
		                continue mainloop;
		            default:
		                System.out.println("Invalid choice. Please try again.");
		        }
		    }
		case 3:
			System.out.println("Exiting The Application...Thank You");
			return;
			
		
		default:
			System.out.println("Choose Correct Option");
		}
		
		
		}
	
	}
		
}
		
			
		
