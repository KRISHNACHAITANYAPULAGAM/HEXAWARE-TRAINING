package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static String getPropertyString(String path) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            props.load(fis);
            String host = props.getProperty("hostname");
            String db = props.getProperty("dbname");
            String user = props.getProperty("username");
            String pass = props.getProperty("password");
            String port = props.getProperty("port");

            return "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
