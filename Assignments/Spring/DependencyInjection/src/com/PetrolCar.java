package com;

public class PetrolCar implements ICar{



    //dependency injection part
    private IIconicSound iIconicSound;

    public PetrolCar(IIconicSound iIconicSound){
        this.iIconicSound=iIconicSound;
    }

    @Override
    public void runsOn() {
        System.out.println("Runs on Petrol");
    }

    @Override
    public String soundItMakes() {
        return iIconicSound.whatSound();
    }
}
