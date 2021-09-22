package com.springboot.racingdemo.service;

import com.springboot.racingdemo.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> findAll();

    public Car findById(int theId);

    public void save(Car theCar);

    public void deleteById(int theId);

}
