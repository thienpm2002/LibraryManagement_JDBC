
import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.ReaderController;
import controller.UserController;
import models.Book;
import models.User;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int luachon;
        do {
            System.out.println("------------------ Library Management ----------------------");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("0. Exit");
            System.out.println("Enter: ");
            luachon = s.nextInt();
            s.nextLine();
            switch (luachon) {
                case 1: {
                    System.out.println("Enter email: ");
                    String email = s.nextLine();
                    System.out.println("Enter password: ");
                    String password = s.nextLine();
                    User user = UserController.login(email, password);
                    if (user.getId() == 0) {
                        System.out.println("Invalid email or password");
                    } else {
                        int userAction;
                        if ("admin".equals(user.getRole())) {
                            do {
                                System.out.println("------------------ Admin ----------------------");
                                System.out.println("1.List book");
                                System.out.println("2.Insert book");
                                System.out.println("3.Update book");
                                System.out.println("4.Delete book");
                                System.out.println("5.Delete user");
                                System.out.println("0. Logout");
                                System.out.println("Enter: ");
                                userAction = s.nextInt();
                                s.nextLine();
                                switch (userAction) {
                                    case 1: {
                                        ArrayList<Book> books = BookController.getBooks();
                                        if (books.size() == 0)
                                            System.out.println("List book is empty");
                                        else {
                                            for (Book book : books) {
                                                System.out.println(book.toString());
                                            }
                                        }
                                        break;
                                    }

                                    case 2: {
                                        System.out.println("Book name:");
                                        String name = s.nextLine();
                                        System.out.println("Author:");
                                        String author = s.nextLine();
                                        System.out.println("Stock:");
                                        int stock = s.nextInt();
                                        s.nextLine();
                                        System.out.println("Category:");
                                        String category = s.nextLine();

                                        int result = BookController.insertBook(name, author, stock, category);
                                        if (result > 0)
                                            System.out.println("Insert book successlly!");
                                        else
                                            System.out.println("Insert book fail!");
                                        break;
                                    }

                                    case 3: {
                                        System.out.println("Book id:");
                                        int book_id = s.nextInt();
                                        System.out.println(" New stock:");
                                        int stock = s.nextInt();

                                        int result = BookController.updateBook(book_id, stock);
                                        if (result > 0)
                                            System.out.println("Update book successlly!");
                                        else
                                            System.out.println("Update book fail!");

                                        break;
                                    }

                                    case 4: {
                                        System.out.println("Book id:");
                                        int book_id = s.nextInt();

                                        int result = BookController.deleteBook(book_id);
                                        if (result > 0)
                                            System.out.println("Delete book successlly!");
                                        else
                                            System.out.println("Delete book fail!");

                                        break;
                                    }

                                    case 0: {
                                        System.out.println("Logout successlly!");
                                        break;
                                    }

                                    default:
                                        break;
                                }
                            } while (userAction != 0);
                        } else {
                            do {
                                System.out.println("------------------ Home ----------------------");
                                System.out.println("1.List book");
                                System.out.println("2.Borrow book");
                                System.out.println("3.Return book");
                                System.out.println("4.Update name");
                                System.out.println("0. Logout");
                                System.out.println("Enter: ");
                                userAction = s.nextInt();
                                s.nextLine();
                                switch (userAction) {
                                    case 1: {
                                        ArrayList<Book> books = BookController.getBooks();
                                        if (books.size() == 0)
                                            System.out.println("List book is empty");
                                        else {
                                            for (Book book : books) {
                                                System.out.println(book.toString());
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Enter book_id: ");
                                        int book_id = s.nextInt();
                                        s.nextLine();
                                        System.out.println("Enter quantity: ");
                                        int quantity = s.nextInt();
                                        s.nextLine();
                                        boolean res = ReaderController.borrowBook(user.getId(), book_id, quantity);
                                        if (res)
                                            System.out.println("Borrow sucessfully!");
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Enter book_id: ");
                                        int book_id = s.nextInt();
                                        s.nextLine();
                                        boolean res = ReaderController.returnBook(user.getId(), book_id);
                                        if (res)
                                            System.out.println("Return sucessfully!");
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Enter new name: ");
                                        String newName = s.nextLine();
                                        boolean res = ReaderController.updateName(user.getId(), newName);
                                        if (res)
                                            System.out.println("Update name sucessfully!");
                                        break;
                                    }
                                    case 0: {
                                        System.out.println("Logout successlly!");
                                        break;
                                    }

                                    default:
                                        break;
                                }
                            } while (userAction != 0);
                        }

                    }

                    break;
                }

                case 2: {
                    System.out.println("Enter email: ");
                    String email = s.nextLine();
                    System.out.println("Enter password: ");
                    String password = s.nextLine();
                    System.out.println("Enter name: ");
                    String name = s.nextLine();
                    int result = UserController.register(email, password, name);
                    if (result == -1) {
                        System.out.println("Email is exist");
                    } else
                        System.out.println("Register successfully!");

                    break;
                }

                case 0: {
                    System.out.println("Exit successlly!");
                    break;
                }
                default:
                    break;
            }
        } while (luachon != 0);
        s.close();
    }
}
