package models;

import java.sql.Timestamp;

public class Borrow {
    private int id;
    private int reader_id;
    private int book_id;
    private int quantity;
    private Timestamp borrowDate;
    private Timestamp returnDate;
    private String status;

    public Borrow() {
    }

    public Borrow(int id, int reader_id, int book_id, int quantity, Timestamp borrowDate, Timestamp returnDate,
            String status) {
        this.id = id;
        this.reader_id = reader_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Borrow(int reader_id, int book_id, int quantity) {
        this.reader_id = reader_id;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReaderId() {
        return reader_id;
    }

    public void setReaderId(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getBookId() {
        return book_id;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrow [id=" + id + ", reader_id=" + reader_id + ", book_id=" + book_id + ", quantity=" + quantity
                + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + ", status=" + status + "]";
    }

}
