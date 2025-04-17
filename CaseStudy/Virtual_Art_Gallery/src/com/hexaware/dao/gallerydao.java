package com.hexaware.dao;
import java.sql.SQLException;

import com.hexaware.entity.gallery;


public interface gallerydao {
    void addGallery(gallery g);
    void updateGallery(String columnName, String newValue, String conditionColumn, String conditionValue);
    void deleteGallery(String columnName, String value);
    void viewGalleries() throws SQLException;
}
