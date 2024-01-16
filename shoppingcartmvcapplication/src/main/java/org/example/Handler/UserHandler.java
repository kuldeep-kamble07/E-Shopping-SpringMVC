package org.example.Handler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.DTO.LoginDTO;
import org.example.DTO.UserDto;
import org.example.Dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    private static final Logger LOGGER = LogManager.getLogger(UserHandler.class);

    @Autowired
    private UserDao userDao;

    public String addUser(User user) {
        try {
            LOGGER.info("start::UserHandler::addUser::");

            userDao.addUser(user);

            LOGGER.info("User registered successfully!");
            return "User Register Successfully !";
        } catch (Exception e) {
            LOGGER.error("Error registering user", e);
            throw new RuntimeException("Error registering user", e);
        }
    }

}
