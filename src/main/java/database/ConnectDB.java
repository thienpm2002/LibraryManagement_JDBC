package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectDB {
    public static Connection connect() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASS");
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connect successfully!");
            return conn;
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Error connect: " + e.getMessage());
            return null;
        }
    }

    public static void disconnect(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Disconnect successfully");
            }
        } catch (Exception e) {
            System.out.println("Error disconnect: " + e.getMessage());
        }
    }
}
