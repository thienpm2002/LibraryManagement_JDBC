package controller;

import java.util.ArrayList;

import dao.BookDAO;
import models.Book;

public class BookController {
    static BookDAO bookDao = BookDAO.getInstance();

    public static ArrayList<Book> getBooks() {
        return bookDao.selectAll();
    }

    public static int insertBook(String name, String author, int stock, String category) {
        Book newBook = new Book(name, author, stock, category);
        return bookDao.insert(newBook);
    }

    public static int updateBook(int book_id, int stock) {
        Book book = bookDao.selectById(book_id);
        if (book.getId() == 0) {
            System.out.println("Book is not exist");
            return 0;
        }
        book.setStock(stock);
        return bookDao.update(book);
    }

    public static int deleteBook(int book_id) {
        Book book = bookDao.selectById(book_id);
        if (book.getId() == 0) {
            System.out.println("Book is not exist");
            return 0;
        }
        return bookDao.delete(book);
    }
}
