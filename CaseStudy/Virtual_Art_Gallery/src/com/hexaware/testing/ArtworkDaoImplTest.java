package com.hexaware.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.daoimpl.ArtworkDaoImpl;
import com.hexaware.entity.artwork;
import com.hexaware.exceptions.ArtWorkNotFoundException;

public class ArtworkDaoImplTest {

    private ArtworkDaoImpl dao;

    @BeforeEach
    public void setUp() {
        dao = new ArtworkDaoImpl();
    }

    @Test
    public void testAddArtwork() {
        artwork art = new artwork();
        art.setartworkid(3001);
        art.setTitle("JUnit Test Art");
        art.setDescription("Art for JUnit testing");
        art.setCreationdate("2025-04-10");
        art.setMedium("Digital");
        art.setImageURL("https://image.url/test.jpg");
        art.setArtistID(1);

        assertDoesNotThrow(() -> dao.Addartwork(art), "Addartwork should not throw exception");
    }

    @Test
    public void testUpdateArtworkDetails() {
        assertDoesNotThrow(() -> {
            dao.UpdateArtworkDetails("Title", "Updated JUnit Art", 3001);
        }, "UpdateArtworkDetails should not throw exception for valid ArtworkID and column");
    }

    @Test
    public void testDeleteArtwork() {
        assertDoesNotThrow(() -> {
            dao.deleteArtwork("ArtworkID", "3001");
        }, "deleteArtwork should not throw exception for valid ArtworkID");
    }

    @Test
    public void testCheckIntExists() {
        try {
            boolean exists = dao.checkint(1); // use an existing ArtworkID from your DB
            assertTrue(exists, "Artwork with ID 1001 should exist");
        } catch (SQLException | ArtWorkNotFoundException e) {
            fail("Exception thrown while checking int exists: " + e.getMessage());
        }
    }

    @Test
    public void testCheckIntNotExists() {
        try {
            boolean exists = dao.checkint(9999); // use a non-existing ArtworkID
            assertFalse(exists, "Artwork with ID 9999 should not exist");
        } catch (SQLException | ArtWorkNotFoundException e) {
            fail("Exception thrown while checking int does not exist: " + e.getMessage());
        }
    }

    @Test
    public void testShowArtworks() {
        assertDoesNotThrow(() -> {
            dao.showArtworks(); // This will print all artworks
        }, "showArtworks should not throw exception");
    }
}
