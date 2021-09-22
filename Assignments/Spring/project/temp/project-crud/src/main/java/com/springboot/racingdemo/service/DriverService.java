package com.springboot.racingdemo.service;

import java.util.List;

import com.springboot.racingdemo.entity.Driver;

public interface DriverService {

    List<Driver> findAll();

    Driver findById(int theId);

    void save(Driver theDriver);

    void deleteById(int theId);

}
