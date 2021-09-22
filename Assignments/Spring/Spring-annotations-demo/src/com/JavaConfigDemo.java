package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        ICar iCar1 = context.getBean("electricCar", ICar.class);
        System.out.println(iCar1.runsOn());

        //Autowiring implementation
        System.out.println(iCar1.specialFeatures());

        context.close();
    }
}
