package models;

import java.sql.Date;

public class Borrow {
    private int id;
    private int reader_id;
    private int book_id;
    private Date borrowDate;
    private Date returnDate;
    private String status;

    public Borrow() {
    }

    public Borrow(int id, int reader_id, int book_id, Date borrowDate, Date returnDate, String status) {
        this.id = id;
        this.reader_id = reader_id;
        this.book_id = book_id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Borrow(int reader_id, int book_id, Date borrowDate, Date returnDate, String status) {
        this.reader_id = reader_id;
        this.book_id = book_id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
