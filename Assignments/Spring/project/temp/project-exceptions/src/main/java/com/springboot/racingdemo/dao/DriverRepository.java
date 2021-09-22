package com.springboot.racingdemo.dao;

import java.util.List;

import com.springboot.racingdemo.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Driver> findAllByOrderByTrackNameAsc();

}
