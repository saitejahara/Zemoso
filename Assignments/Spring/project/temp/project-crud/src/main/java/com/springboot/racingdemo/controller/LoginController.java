package com.springboot.racingdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController
{

    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }

    @GetMapping("/login")
    public String showMyLoginPage()
    {
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
