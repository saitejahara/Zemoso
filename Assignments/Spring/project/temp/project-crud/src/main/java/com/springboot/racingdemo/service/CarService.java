package com.springboot.racingdemo.service;

import com.springboot.racingdemo.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(int theId);

    void save(Car theCar);

    void deleteById(int theId);

    List<Car> findAllMock();

}
