package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContect2.xml");
        ICar iCar1= context.getBean("carID",ICar.class);
        ICar iCar2= context.getBean("carID",ICar.class);

        if(iCar1==iCar2){
            System.out.println("Pointing to the same obj");
        }
        else {
            System.out.println("Pointing to different objectsBeanScopeDemo");
        }
    }
}
