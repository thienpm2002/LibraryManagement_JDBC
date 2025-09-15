package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/library_management";
        String user = "root";
        String password = "123456";

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
