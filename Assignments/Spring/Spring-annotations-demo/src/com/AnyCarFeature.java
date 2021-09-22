package com;

import org.springframework.stereotype.Component;

//@Component
public class AnyCarFeature implements SpecialFeature{

    @Override
    public String getSpecialFeature() {
        return "Transportation";
    }
}
