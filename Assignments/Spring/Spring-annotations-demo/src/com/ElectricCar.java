package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//  @Scope("prototype")
public class ElectricCar implements ICar{

    //field injection
    @Autowired
    @Qualifier("randomSpecialFeature")
    private SpecialFeature specialFeature;

    //constructor injection
    /*@Autowired
    public ElectricCar(SpecialFeature specialFeature) {
        this.specialFeature = specialFeature;
    }*/
    public ElectricCar() {
        System.out.println("ElectricCar>> :inside no-arg constructor");
    }

    //setter injection
    /*@Autowired
    public void setSpecialFeature(SpecialFeature specialFeature) {
        System.out.println("ElectricCar>> :inside setSpecialFeatures");
        this.specialFeature = specialFeature;
    }*/

    @Override
    public String runsOn() {
        return "Electricity";
    }

    @Override
    public String specialFeatures() {
        return specialFeature.getSpecialFeature();
    }

    //init method
    @PostConstruct
    public void initMethod(){
        System.out.println("Inside initMethod");
    }

    //destroy method
    @PreDestroy
    public void destroyMethod(){
        System.out.println("Inside destroyMethod");
    }




}
