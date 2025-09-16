package controller;

import java.util.ArrayList;

import dao.BookDAO;
import dao.BorrowDAO;
import dao.ReaderDAO;
import models.Book;
import models.Borrow;
import models.Reader;

public class ReaderController {
    static BookDAO bookDao = BookDAO.getInstance();
    static BorrowDAO borrowDao = BorrowDAO.getInstance();
    static ReaderDAO readerDao = ReaderDAO.getInstance();

    public static ArrayList<Book> getBooks() {
        return bookDao.selectAll();
    }

    public static boolean borrowBook(int user_id, int book_id, int quantity) {
        Book book = bookDao.selectById(book_id);

        if (book.getId() == 0) {
            System.out.println("Book is exist");
            return false;
        }

        if (book.getStock() < quantity) {
            System.out.println("Stock invalid");
            return false;
        }

        Reader reader = readerDao.selectByUserId(user_id);
        if (reader.getId() == 0)
            return false;

        String condition = "reader_id = '" + reader.getId() + "' AND book_id = '" + book_id + "'";
        ArrayList<Borrow> borrows = borrowDao.selectByCondition(condition);
        if (borrows.size() > 0) {
            System.out.println("Please return the newly borrowed book.");
            return false;
        }

        Borrow borrow = new Borrow(reader.getId(), book_id, quantity);
        int result = borrowDao.insert(borrow);

        if (result == 0)
            return false;

        int stock = book.getStock() - quantity;
        book.setStock(stock);
        bookDao.update(book);
        return true;
    }
}
