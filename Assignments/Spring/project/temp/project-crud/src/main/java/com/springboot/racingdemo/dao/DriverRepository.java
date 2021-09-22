package com.springboot.racingdemo.dao;

import java.util.List;

import com.springboot.racingdemo.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {


    // add a method to sort by track name
    List<Driver> findAllByOrderByTrackNameAsc();

}
