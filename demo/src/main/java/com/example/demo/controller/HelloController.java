package com.example.demo.controller;

import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsAdmin;
import com.example.demo.security.IsUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {


    @GetMapping("/")
    public String hello() {
        return "Hello Anonyme";
    }

    @IsUser
    @GetMapping("/hello-user")
    public String helloUser(@AuthenticationPrincipal AppUserDetails userDetails) {
        return "<h1> Hello " + userDetails.getUtilisateur().getId() + "</h1>";
    }

    @IsAdmin
    @GetMapping("/hello-admin")
    public String helloAdmin(@AuthenticationPrincipal AppUserDetails userDetails) {
        return "<h1> Hello " + userDetails.getUtilisateur().getId() + ". You are an admin </h1>";
    }
}