package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

public interface UserFavoriteArtworkDao {
    List<String> getFavoriteArtworksByUserId(int userId,String Username) throws SQLException;
    public boolean addFavoriteArtwork(int userId, int artworkId) throws SQLException;
    public boolean  removeFavoriteArtwork(int userId, int artworkId) throws SQLException;
}
