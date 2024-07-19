package com.example.managinv.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/auth")

//@RequestMapping("/")
public class AuthController{

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello-secured")
    public String helloSecured(){
        return "Hello Secured";
    }
}