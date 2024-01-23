package org.example.Handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.DTO.LoginDTO;
import org.example.DTO.UserDto;
import org.example.Dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class UserHandler {

    private static final Logger LOGGER = LogManager.getLogger(UserHandler.class);

    @Autowired
    private UserDao userDao;


    public void validateUser(User user) throws ValidationException {
        if (StringUtils.isBlank(user.getFirstname()) || StringUtils.isBlank(user.getLastname()) || StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(user.getMobileNo()) || StringUtils.isBlank(user.getPassword())) {
            throw new ValidationException("Invalid input. Please provide values for all user properties.");
        }
    }
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
