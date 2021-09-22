package com.springboot.racingdemo.service;

import com.springboot.racingdemo.dao.CarRepository;
import com.springboot.racingdemo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository theCarRepository) {
        carRepository = theCarRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAllByOrderByCarNameAsc();
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> result = carRepository.findById(theId);

        Car theCar = null;

        if (result.isPresent()) {
            theCar = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find car with id - " + theId);
        }

        return theCar;
    }

    @Override
    public void save(Car theCar) {
        carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }

}