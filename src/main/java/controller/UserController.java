package controller;

import java.util.ArrayList;

import dao.ReaderDAO;
import dao.UserDAO;
import models.Reader;
import models.User;

public class UserController {

    static UserDAO userDao = UserDAO.getInstance();
    static ReaderDAO readerDao = ReaderDAO.getInstance();

    public static User login(String email, String password) {
        User user = new User();
        String condition = "email = '" + email + "' AND password = '" + password + "'";
        ArrayList<User> users = userDao.selectByCondition(condition);
        if (users.size() != 0)
            user = users.get(0);
        return user;
    }

    public static int register(String email, String password, String name) {
        User user = userDao.selectByEmail(email); // check email
        if (user.getId() != 0) {
            return -1;
        }
        User newUser = new User(email, password);
        int insertUser = userDao.insert(newUser);
        if (insertUser > 0) {
            newUser = userDao.selectByEmail(email);
        }
        Reader reader = new Reader(name, newUser.getId());
        int insertReader = readerDao.insert(reader);
        return insertReader;
    }

}
