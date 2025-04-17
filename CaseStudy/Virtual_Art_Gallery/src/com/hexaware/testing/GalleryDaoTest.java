package com.hexaware.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.daoimpl.GalleryDaoImpl;
import com.hexaware.entity.gallery;

public class GalleryDaoTest {

    private GalleryDaoImpl galleryDao;
    private static final String TEST_NAME = "Test Gallery";

    @BeforeEach
    public void setUp() {
        galleryDao = new GalleryDaoImpl();
    }

    @Test
    public void testAddGallery() {
        gallery g = new gallery();
        g.setName(TEST_NAME);
        g.setDescription("JUnit Test Gallery Description");
        g.setLocation("Test Location");
        g.setCurator(1);
        g.setOpeningTime("10:00:00");

        assertDoesNotThrow(() -> galleryDao.addGallery(g), "addGallery should not throw exception");
    }

    @Test
    public void testUpdateGallery() {
        assertDoesNotThrow(() -> {
            galleryDao.updateGallery("Curator", "Updated Curator", "Name", TEST_NAME);
        }, "updateGallery should not throw exception for valid gallery details");
    }

    @Test
    public void testViewGalleries() {
        assertDoesNotThrow(() -> {
            galleryDao.viewGalleries();
        }, "viewGalleries should not throw exception");
    }

    @Test
    public void testDeleteGallery() {
        assertDoesNotThrow(() -> {
            galleryDao.deleteGallery("Name", TEST_NAME);
        }, "deleteGallery should not throw exception for valid gallery details");
    }
}
