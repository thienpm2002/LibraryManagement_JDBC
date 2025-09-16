package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import models.Borrow;

public class BorrowDAO implements DAOInterface<Borrow> {

    private static BorrowDAO instance = new BorrowDAO();

    private BorrowDAO() {
    }

    public static BorrowDAO getInstance() {
        return instance;
    }

    @Override
    public int delete(Borrow t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "DELETE FROM borrows WHERE id = ?";
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
    public int insert(Borrow t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "INSERT INTO borrows (reader_id, book_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getReaderId());
            ps.setInt(2, t.getBookId());
            ps.setInt(3, t.getQuantity());
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
    public ArrayList<Borrow> selectAll() {
        ArrayList<Borrow> borrows = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM borrows";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int readerId = rs.getInt("reader_id");
                int bookId = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                java.sql.Date borrowDate = rs.getDate("borrow_date");
                java.sql.Date returnDate = rs.getDate("return_date");
                String status = rs.getString("status");
                borrows.add(new Borrow(id, readerId, bookId, quantity, borrowDate, returnDate, status));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return borrows;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Borrow> selectByCondition(String condition) {
        ArrayList<Borrow> borrows = new ArrayList<>();
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM borrows WHERE " + condition;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int readerId = rs.getInt("reader_id");
                int bookId = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                java.sql.Date borrowDate = rs.getDate("borrowDate");
                java.sql.Date returnDate = rs.getDate("returnDate");
                String status = rs.getString("status");
                borrows.add(new Borrow(id, readerId, bookId, quantity, borrowDate, returnDate, status));
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return borrows;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Borrow selectById(int id) {
        Borrow borrow = null;
        try {
            Connection conn = ConnectDB.connect();
            String sql = "SELECT * FROM borrows WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int readerId = rs.getInt("reader_id");
                int bookId = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                java.sql.Date borrowDate = rs.getDate("borrow_date");
                java.sql.Date returnDate = rs.getDate("return_date");
                String status = rs.getString("status");
                borrow = new Borrow(id, readerId, bookId, quantity, borrowDate, returnDate, status);
            }

            rs.close();
            ps.close();
            ConnectDB.disconnect(conn);
            return borrow;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int update(Borrow t) {
        try {
            Connection conn = ConnectDB.connect();
            String sql = "UPDATE borrows SET reader_id = ?, book_id = ?, borrow_date = ?, return_date = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getReaderId());
            ps.setInt(2, t.getBookId());
            ps.setDate(3, t.getBorrowDate());
            ps.setDate(4, t.getReturnDate());
            ps.setInt(5, t.getId());

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
