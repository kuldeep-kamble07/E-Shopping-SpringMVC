package org.example.controller;

import org.example.DTO.LoginDTO;
import org.example.Handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    private LoginHandler loginHandler;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDto) {

      return ResponseEntity.ok(loginHandler.login(loginDto));
    }
}
