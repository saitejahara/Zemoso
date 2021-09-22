package com.springboot.racingdemo.service;

import java.util.List;
import java.util.Optional;

import com.springboot.racingdemo.dao.DriverRepository;
import com.springboot.racingdemo.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository theDriverRepository) {
        driverRepository = theDriverRepository;
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAllByOrderByTrackNameAsc();
    }

    @Override
    public Driver findById(int theId) {

        Optional<Driver> result = driverRepository.findById(theId);

        Driver theDriver = null;

        if (result.isPresent()) {
            theDriver = result.get();
        }
        else {
            // we didn't find the driver
            throw new RuntimeException("Did not find driver with id - " + theId);
        }

        return theDriver;
    }

    @Override
    public void save(Driver theDriver) {
        driverRepository.save(theDriver);
    }

    @Override
    public void deleteById(int theId) {
        driverRepository.deleteById(theId);
    }

}