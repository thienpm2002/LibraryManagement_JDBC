package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import models.User;

public class UserDAO implements DAOInterface<User> {

    private static UserDAO instance = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return instance;
    }

    @Override
    public int delete(User t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getId());

            int result = ps.executeUpdate();

            ps.close();
            ConnectDB.disconnect(conn);
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int insert(User t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getEmail());
            ps.setString(2, t.getPassword());
            int result = ps.executeUpdate();

            ps.close();
            ConnectDB.disconnect(conn);
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                users.add(new User(id, email, password, role));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM users WHERE " + condition;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                users.add(new User(id, email, password, role));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User selectById(int id) {
        User user = new User();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                user = new User(id, email, password, role);
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User selectByEmail(String email) {
        User user = new User();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("role");

                user = new User(id, email, password, role);
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int update(User t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "UPDATE users SET password = ?, role = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getPassword());
            ps.setString(2, t.getRole());
            ps.setInt(3, t.getId());

            int result = ps.executeUpdate();

            ps.close();
            ConnectDB.disconnect(conn);
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
