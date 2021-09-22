package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com")
@PropertySource("classpath:application.properties")
public class CarConfig {




    //define bean for a AnyCaeFeature
    @Bean
    public SpecialFeature anyCarFeature(){
        return new AnyCarFeature();
    }

    //define bean for HydroCar and inject dependency
    @Bean
    public ICar hydroCar(){
        return new HydroCar(anyCarFeature());
    }
}
