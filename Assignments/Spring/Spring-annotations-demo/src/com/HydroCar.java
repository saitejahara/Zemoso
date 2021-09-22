package com;

import org.springframework.beans.factory.annotation.Value;

public class HydroCar implements ICar{

    @Value("${car.regNo}")
    private String regNo;

    @Value("${car.ownerName}")
    private String ownerName;

    public String getRegNo() {
        return regNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    private SpecialFeature specialFeature;

    public HydroCar(SpecialFeature specialFeature){
        this.specialFeature=specialFeature;
    }

    @Override
    public String runsOn() {
        return "Hydrogen";
    }

    @Override
    public String specialFeatures() {
        return specialFeature.getSpecialFeature();
    }
}
