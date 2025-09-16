package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import models.Reader;

public class ReaderDAO implements DAOInterface<Reader> {

    private static ReaderDAO instance = new ReaderDAO();

    private ReaderDAO() {
    }

    public static ReaderDAO getInstance() {
        return instance;
    }

    @Override
    public int delete(Reader t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "DELETE FROM readers WHERE id = ?";
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
    public int insert(Reader t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "INSERT INTO readers (name, user_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setInt(2, t.getUserId());

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
    public ArrayList<Reader> selectAll() {
        ArrayList<Reader> readers = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM readers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int user_id = rs.getInt("user_id");

                readers.add(new Reader(id, name, user_id));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return readers;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Reader> selectByCondition(String condition) {
        ArrayList<Reader> readers = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM readers WHERE " + condition;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int user_id = rs.getInt("user_id");

                readers.add(new Reader(id, name, user_id));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return readers;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Reader selectById(int id) {
        Reader reader = new Reader();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM readers WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int user_id = rs.getInt("user_id");

                reader = new Reader(id, name, user_id);
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return reader;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Reader selectByUserId(int user_id) {
        Reader reader = new Reader();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM readers WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");

                reader = new Reader(id, name, user_id);
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return reader;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int update(Reader t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "UPDATE readers SET name = ?, user_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setInt(2, t.getUserId());
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
