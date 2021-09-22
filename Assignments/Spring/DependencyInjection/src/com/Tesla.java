package com;

public class Tesla implements ICar{




    //dependency injection part
    private IIconicSound iIconicSound;

    public Tesla(IIconicSound iIconicSound){
        this.iIconicSound=iIconicSound;
    }

    @Override
    public void runsOn() {
        System.out.println("Runs on electricity");
    }

    @Override
    public String soundItMakes() {
        //return null;
        return iIconicSound.whatSound();
    }

    //init method
    public void initMethod(){
        System.out.println("In Tesla initMethod");
    }
    //destroy method
    public void destroyMethod(){
        System.out.println("In Tesla destroyMethod");
    }
}
