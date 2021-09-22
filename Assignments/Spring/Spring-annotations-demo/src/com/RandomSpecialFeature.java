package com;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomSpecialFeature implements SpecialFeature{

    private String[] features = {"Super fun to ride",
                                "Eco friendly",
                                "future of transportation"};

    private Random random = new Random();



    @Override
    public String getSpecialFeature() {

        int arrLen = random.nextInt(features.length);

        String specialFeature=features[arrLen];

        return specialFeature;
    }
}
