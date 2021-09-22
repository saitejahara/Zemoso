package com;

import org.springframework.stereotype.Component;

@Component
public class ElectricCarFeature implements SpecialFeature{
    @Override
    public String getSpecialFeature() {
        return "Instant torque";
    }
}
