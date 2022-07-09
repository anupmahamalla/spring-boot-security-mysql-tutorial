package com.anup.springbootsecuritymysqltutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome to Home Page</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome to User Page</h1>");
    }

    @GetMapping("/admin")
    public String adminPage(){
        return ("<h1>Welcome to Admin Page</h1>");
    }



}
