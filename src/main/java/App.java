
import java.util.Scanner;

import controller.UserController;
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
                                System.out.println("1.Insert book");
                                System.out.println("2.Delete book");
                                System.out.println("0. Logout");
                                System.out.println("Enter: ");
                                userAction = s.nextInt();
                                s.nextLine();
                                switch (userAction) {
                                    case 1:

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
                                System.out.println("0. Logout");
                                System.out.println("Enter: ");
                                userAction = s.nextInt();
                                s.nextLine();
                                switch (userAction) {
                                    case 1:

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
                    } else {
                        int userAction;
                        do {
                            System.out.println("------------------ Home ----------------------");
                            System.out.println("1.List book");
                            System.out.println("2.Borrow book");
                            System.out.println("0. Logout");
                            System.out.println("Enter: ");
                            userAction = s.nextInt();
                            s.nextLine();
                            switch (userAction) {
                                case 1:

                                case 0: {
                                    System.out.println("Exit successlly!");
                                    break;
                                }

                                default:
                                    break;
                            }
                        } while (userAction != 0);
                    }

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
