package org.example.Handler;

import org.example.Dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    @Autowired
    private UserDao userDao;

    public String addUser(User user) {
        userDao.addUser(user);
        return "User Register Successfully !";
    }
}
