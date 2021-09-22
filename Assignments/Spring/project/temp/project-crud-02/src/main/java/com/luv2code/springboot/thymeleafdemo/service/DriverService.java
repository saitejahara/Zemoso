package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Driver;

public interface DriverService {

    public List<Driver> findAll();

    public Driver findById(int theId);

    public void save(Driver theDriver);

    public void deleteById(int theId);

}
