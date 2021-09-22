package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println("Student first name: "+student.getFirstName() );
        System.out.println("Student last name: "+student.getLastName());
        System.out.println("Student country: "+student.getCountry());
        System.out.println("Student favorite language: "+student.getFavoriteLanguage());

        return "student-confirmation";
    }
}
