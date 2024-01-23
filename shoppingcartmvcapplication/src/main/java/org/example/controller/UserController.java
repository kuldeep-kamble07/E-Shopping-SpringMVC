package org.example.controller;

import org.example.DTO.LoginDTO;
import org.example.DTO.UserDto;
import org.example.Dao.UserDao;
import org.example.Handler.UserHandler;
import org.example.model.Product;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.xml.bind.ValidationException;

@Controller
public class UserController {

    @Autowired
    private UserHandler userHandler;

    @GetMapping("/adduser")
    public String addUser(){
        return "adduser";
    }

    @PostMapping(value = "/adduser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) throws ValidationException {
        System.out.println("In Method + ");
        userHandler.validateUser(user);
        return ResponseEntity.ok(userHandler.addUser(user));
    }



}
