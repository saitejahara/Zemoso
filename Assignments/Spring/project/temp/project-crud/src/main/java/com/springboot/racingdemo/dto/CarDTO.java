package com.springboot.racingdemo.dto;


import lombok.Data;

import javax.persistence.*;

@Data
public class CarDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String carName;

    private String modelYear;

    private String fuelType;

    private String intakeType;

    private String power;

    private String torque;

}
