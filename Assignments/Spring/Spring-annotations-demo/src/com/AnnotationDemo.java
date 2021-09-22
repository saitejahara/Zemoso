package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ICar iCar1 = context.getBean("electricCar", ICar.class);
        System.out.println(iCar1.runsOn());

        //Autowiring implementation
        System.out.println(iCar1.specialFeatures());

        context.close();
    }
}
