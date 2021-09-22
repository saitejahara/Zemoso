package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/something")
    public String testString(){
        return "home";
    }

    public static void main(String[] args) {
        //control of inversion
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContect.xml");

        ICar iCar1 = context.getBean("carID", ICar.class);

        iCar1.runsOn();


        //dependency injection
        System.out.println(iCar1.soundItMakes());


        //testing injection of literal values
        OldMustang oldMustang = context.getBean("oldMustangBean", OldMustang.class);
        System.out.println(oldMustang.getRegistrationNumber());
    }
}