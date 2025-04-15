package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = PropertyUtil.getPropertyString("src/util/db.properties");
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
