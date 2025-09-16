package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import models.Book;

public class BookDAO implements DAOInterface<Book> {

    private static BookDAO instance = new BookDAO();

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        return instance;
    }

    @Override
    public int delete(Book t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "DELETE FROM books WHERE id = ?";
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
    public int insert(Book t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "INSERT INTO books (name, author, stock, category) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getAuthor());
            ps.setInt(3, t.getStock());
            ps.setString(4, t.getCategory());

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
    public ArrayList<Book> selectAll() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String author = result.getString("author");
                String category = result.getString("category");
                int stock = result.getInt("stock");
                books.add(new Book(id, name, author, stock, category));
            }

            result.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return books;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Book> selectByCondition(String condition) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM books WHERE " + condition;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String author = result.getString("author");
                String category = result.getString("category");
                int stock = result.getInt("stock");
                books.add(new Book(id, name, author, stock, category));
            }

            result.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return books;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Book selectById(int id) {
        Book book = new Book();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM books WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                String name = result.getString("name");
                String author = result.getString("author");
                String category = result.getString("category");
                int stock = result.getInt("stock");
                book = new Book(id, name, author, stock, category);
            }

            result.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return book;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int update(Book t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "UPDATE books SET stock = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getStock());
            ps.setInt(2, t.getId());
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
