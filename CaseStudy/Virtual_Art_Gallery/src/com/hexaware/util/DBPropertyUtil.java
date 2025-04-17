package com.hexaware.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getPropertyString(String filename) {
        Properties props = new Properties();
        try {
            
            ClassLoader loader = DBPropertyUtil.class.getClassLoader();
            try (InputStream fis = loader.getResourceAsStream("com/hexaware/util/" + filename)) {
                if (fis == null) {
                    System.out.println("Could not find the file: " + filename);
                    return null;
                }
                props.load(fis);
            }

            String host = props.getProperty("host");
            String port = props.getProperty("port");
            String db = props.getProperty("database");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            return "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;

        } catch (IOException e) {
            System.out.println("Error reading property file: " + e.getMessage());
            return null;
        }
    }
}
