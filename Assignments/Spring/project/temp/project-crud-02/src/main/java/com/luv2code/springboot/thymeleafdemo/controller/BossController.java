package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Car;
import com.luv2code.springboot.thymeleafdemo.entity.Driver;
import com.luv2code.springboot.thymeleafdemo.service.CarService;
import com.luv2code.springboot.thymeleafdemo.service.DriverService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Controller
@RequestMapping("/boss")
public class BossController {




    private CarService carService;

    public BossController(CarService theCarService, DriverService theDriverService) {
        carService = theCarService;
        driverService = theDriverService;
    }

    // add mapping for "/list"

    @GetMapping("/cars/list")
    public String listCar(Model theModel) {

        // get cars from db
        List<Car> theCar = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCar);

        return "cars/list-cars";
    }

    @GetMapping("/cars/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Car theCar = new Car();

        theModel.addAttribute("car", theCar);

        return "cars/car-form";
    }

    @GetMapping("/cars/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int theId,
                                    Model theModel) {

        // get the driver from the service
        Car theCar = carService.findById(theId);

        // set driver as a model attribute to pre-populate the form
        theModel.addAttribute("car", theCar);

        // send over to our form
        return "cars/car-form";
    }


    @PostMapping("/cars/save")
    public String saveDriver(@ModelAttribute("car") Car theCar) {

        // save the driver
        carService.save(theCar);

        System.out.println("saved car");
        // use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";
    }


    @GetMapping("/cars/delete")
    public String delete(@RequestParam("carId") int theId) {

        // delete the car
        carService.deleteById(theId);

        // redirect to /cars/list
        return "redirect:/cars/list";

    }






    private DriverService driverService;

    /*public DriverController(DriverService theDriverService) {
        driverService = theDriverService;
    }*/

    // add mapping for "/list"

    @GetMapping("/drivers/list")
    public String listDrivers(Model theModel) {

        // get drivers from db
        List<Driver> theDrivers = driverService.findAll();

        // add to the spring model
        theModel.addAttribute("drivers", theDrivers);

        return "drivers/list-driver";
    }

    @GetMapping("/drivers/showFormForAdd")
    public String showFormForAddDriver(Model theModel) {

        // create model attribute to bind form data
        Driver theDriver = new Driver();

        theModel.addAttribute("driver", theDriver);

        return "drivers/driver-form";
    }

    @GetMapping("/drivers/showFormForUpdate")
    public String showFormForUpdateDriver(@RequestParam("driverId") int theId,
                                    Model theModel) {

        // get the driver from the service
        Driver theDriver = driverService.findById(theId);

        // set driver as a model attribute to pre-populate the form
        theModel.addAttribute("driver", theDriver);

        // send over to our form
        return "drivers/driver-form";
    }


    @PostMapping("/drivers/save")
    public String saveDriver(@ModelAttribute("driver") Driver theDriver) {

        // save the driver
        driverService.save(theDriver);

        System.out.println("saved driver");
        // use a redirect to prevent duplicate submissions
        return "redirect:/drivers/list";
    }


    @GetMapping("/drivers/delete")
    public String deleteDriver(@RequestParam("driverId") int theId) {

        // delete the driver
        driverService.deleteById(theId);

        // redirect to /drivers/list
        return "redirect:/drivers/list";

    }

}