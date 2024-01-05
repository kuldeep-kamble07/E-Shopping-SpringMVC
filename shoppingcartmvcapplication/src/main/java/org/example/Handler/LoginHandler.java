package org.example.Handler;

import org.example.DTO.LoginDTO;
import org.example.Dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler implements UserHandlerI {

    @Autowired
    private UserDao userDao;
    @Override
    public String login(LoginDTO loginDTO) {
        try {
            User user = userDao.getByEmail(loginDTO.getEmail());
            if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
                return "Login Successfully !";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid Username / Password";
    }
}
