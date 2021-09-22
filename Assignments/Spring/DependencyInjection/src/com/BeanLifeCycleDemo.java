package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContect3.xml");
        ICar iCar1= context.getBean("carID",ICar.class);
        iCar1.runsOn();
        context.close();
    }
}
