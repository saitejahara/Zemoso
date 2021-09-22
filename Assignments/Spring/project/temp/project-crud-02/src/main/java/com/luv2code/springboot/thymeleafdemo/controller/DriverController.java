package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Driver;
import com.luv2code.springboot.thymeleafdemo.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService theDriverService) {
        driverService = theDriverService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listDrivers(Model theModel) {

        // get drivers from db
        List<Driver> theDrivers = driverService.findAll();

        // add to the spring model
        theModel.addAttribute("drivers", theDrivers);

        return "drivers/list-drivers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Driver theDriver = new Driver();

        theModel.addAttribute("driver", theDriver);

        return "drivers/driver-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("driverId") int theId,
                                    Model theModel) {

        // get the driver from the service
        Driver theDriver = driverService.findById(theId);

        // set driver as a model attribute to pre-populate the form
        theModel.addAttribute("driver", theDriver);

        // send over to our form
        return "drivers/driver-form";
    }


    @PostMapping("/save")
    public String saveDriver(@ModelAttribute("driver") Driver theDriver) {

        // save the driver
        driverService.save(theDriver);

        System.out.println("saved driver");
        // use a redirect to prevent duplicate submissions
        return "redirect:/drivers/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("driverId") int theId) {

        // delete the driver
        driverService.deleteById(theId);

        // redirect to /drivers/list
        return "redirect:/drivers/list";

    }
}
