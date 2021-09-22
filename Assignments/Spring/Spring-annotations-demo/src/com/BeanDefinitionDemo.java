package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        HydroCar hydroCar = context.getBean("hydroCar", HydroCar.class);
        System.out.println(hydroCar.runsOn());

        //Autowiring implementation
        System.out.println(hydroCar.specialFeatures());

        //Java bean defination
        System.out.println("Name of vehicle owner: "+hydroCar.getOwnerName());
        System.out.println("Reg. No. of the vehicle: "+hydroCar.getRegNo());


        context.close();
    }
}
