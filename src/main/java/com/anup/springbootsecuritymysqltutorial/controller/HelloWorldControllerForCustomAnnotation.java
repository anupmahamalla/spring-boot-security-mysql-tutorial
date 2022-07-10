package com.anup.springbootsecuritymysqltutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloWorldControllerForCustomAnnotation {

    @GetMapping("/custom-annotation/{message}")
    @Traceable
    public String user(@PathVariable String message, HttpServletRequest httpServletRequest){
        return ("<h1>Welcome to custome Annotaton page </h1>");
    }


}
