package com;

//import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/main")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloWorldForm";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloUser";
    }

    @RequestMapping("/toUpperOne")
    public String convertToUpper(HttpServletRequest request, Model model){

        String uname = request.getParameter("userName");
        uname = uname.toUpperCase();

        String result = "User name in uppercase using Servlet is "+uname;

        model.addAttribute("message",result);

        return "helloUser";
    }

    @RequestMapping("/toUpperTwo")
    public String convertToUpperTwo(
            @RequestParam("userName") String uname,
            Model model){
        uname = uname.toUpperCase();

        String result = "User name in uppercase using RequestParam is "+uname;

        model.addAttribute("message",result);

        return "helloUser";
    }

}