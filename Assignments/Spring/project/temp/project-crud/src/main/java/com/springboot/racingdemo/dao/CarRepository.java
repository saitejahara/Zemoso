package com.springboot.racingdemo.dao;

import com.springboot.racingdemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // add a method to sort by car name
    List<Car> findAllByOrderByCarNameAsc();

}
