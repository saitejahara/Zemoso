package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ICar iCar1 = context.getBean("electricCar", ICar.class);
        ICar iCar2 = context.getBean("electricCar", ICar.class);

        Boolean match = (iCar1==iCar2);

        System.out.println(match);
    }
}
