package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/buyproduct")
    public String addproduct(){
        return "buyproduct";
    }
}
