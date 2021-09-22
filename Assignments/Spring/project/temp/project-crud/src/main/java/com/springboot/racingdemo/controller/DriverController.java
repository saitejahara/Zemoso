package com.springboot.racingdemo.controller;

import java.security.Principal;
import java.util.List;

import com.springboot.racingdemo.entity.Car;
import com.springboot.racingdemo.entity.Driver;
import com.springboot.racingdemo.service.CarService;
import com.springboot.racingdemo.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private CarService carService;
    private DriverService driverService;

    public DriverController(CarService theCarService, DriverService theDriverService) {
        driverService = theDriverService;
        carService = theCarService;
    }

    // add mapping for "/list"

    @GetMapping("/availableCars")
    public String listCar(Model theModel) {

        // get cars from db
        List<Car> theCar = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCar);

        return "cars/show-cars";
    }


    @GetMapping("/pick")
    public String pickCar(@RequestParam("carId") int carId, HttpServletRequest request) {


        Principal principal = request.getUserPrincipal();

        int driverID=Integer.parseInt(principal.getName());
        System.out.println("Principal ID: "+driverID);

        Driver theDriver;
        theDriver = driverService.findById(driverID);

        System.out.println("Driver ID: "+theDriver.getId());
        Car theCar = carService.findById(carId);
        System.out.println("Car ID: "+theCar.getId());

        theDriver.setCar(theCar);
        System.out.println(theDriver.getCar());
        driverService.save(theDriver);

        // redirect to /drivers/list
        return "redirect:/driver/availableCars";
    }
}
