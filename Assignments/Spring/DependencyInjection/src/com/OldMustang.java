package com;

public class OldMustang implements ICar {

    //injecting literal values
    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        System.out.println("Inside setRegistrationNumber of Tesla class");
        this.registrationNumber = registrationNumber;
    }

    @Override
    public void runsOn() {
        System.out.println("Gas and Respect");
    }

    @Override
    public String soundItMakes() {
        return "gurug gurug gurug gurug";
    }
}
