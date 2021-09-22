package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> findAll();

    public Car findById(int theId);

    public void save(Car theCar);

    public void deleteById(int theId);

}
