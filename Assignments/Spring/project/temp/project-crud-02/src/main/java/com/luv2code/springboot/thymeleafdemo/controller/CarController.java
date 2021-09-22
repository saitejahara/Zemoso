package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.service.CarService;
import com.luv2code.springboot.thymeleafdemo.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService theCarService) {
        carService = theCarService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listCar(Model theModel) {

        // get cars from db
        List<Car> theCar = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCar);

        return "cars/list-cars";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Car theCar = new Car();

        theModel.addAttribute("car", theCar);

        return "cars/car-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int theId,
                                    Model theModel) {

        // get the driver from the service
        Car theCar = carService.findById(theId);

        // set driver as a model attribute to pre-populate the form
        theModel.addAttribute("car", theCar);

        // send over to our form
        return "cars/car-form";
    }


    @PostMapping("/save")
    public String saveDriver(@ModelAttribute("car") Car theCar) {

        // save the driver
        carService.save(theCar);

        System.out.println("saved car");
        // use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("carId") int theId) {

        // delete the car
        carService.deleteById(theId);

        // redirect to /cars/list
        return "redirect:/cars/list";

    }
}
