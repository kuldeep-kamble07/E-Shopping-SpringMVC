package org.example.Dao;

import org.example.model.User;

public interface UserDaoI {

    User getByEmail(String email);

}
