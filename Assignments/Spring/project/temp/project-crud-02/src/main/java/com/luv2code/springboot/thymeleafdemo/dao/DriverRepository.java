package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Driver> findAllByOrderByTrackNameAsc();

}
