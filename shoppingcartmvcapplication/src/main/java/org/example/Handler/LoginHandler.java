package org.example.Handler;

import org.example.DTO.LoginDTO;
import org.example.DTO.UserDto;
import org.example.Dao.UserDao;
import org.example.model.User;
import org.springframework.beans.BeanUtils;
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

    @Override
    public UserDto displayUser(LoginDTO loginDTO) {
        try {
            User user = userDao.getByEmail(loginDTO.getEmail());
            if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                return userDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Invalid Username / Password");
    }
    }


//public UserDto login(LoginDTO loginDTO) {
//    UserDto userDto = null;
//    try {
//        User user = userDao.getByEmail(loginDTO.getEmail());
//        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
//            BeanUtils.copyProperties(user, userDto);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return userDto;
//}