package com.luv2code.springboot.thymeleafdemo.entity;

import javax.persistence.*;


@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="car_name")
    private String carName;

    @Column(name="model_year")
    private String modelYear;

    @Column(name="fuel_type")
    private String fuelType;

    @Column(name="intake_type")
    private String intakeType;

    @Column(name="power")
    private String power;

    @Column(name="torque")
    private String torque;

    public Car() {

    }

    public Car(String carName, String modelYear, String fuelType, String intakeType, String power, String torque) {
        this.carName = carName;
        this.modelYear = modelYear;
        this.fuelType = fuelType;
        this.intakeType = intakeType;
        this.power = power;
        this.torque = torque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getIntakeType() {
        return intakeType;
    }

    public void setIntakeType(String intakeType) {
        this.intakeType = intakeType;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", intakeType='" + intakeType + '\'' +
                ", power='" + power + '\'' +
                ", torque='" + torque + '\'' +
                '}';
    }
}







