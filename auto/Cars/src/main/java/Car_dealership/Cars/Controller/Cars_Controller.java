package Car_dealership.Cars.Controller;

import Car_dealership.Cars.Models.Cars;
import Car_dealership.Cars.Services.Cars_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Cars_Controller {

    @Autowired
    private Cars_Service cars_service;


    @GetMapping({"/list/cars"})
    public ModelAndView getAllCars() {
        ModelAndView mav = new ModelAndView("list-cars");
        mav.addObject("cars", cars_service.getCars());
        return mav;
    }

    @GetMapping("/addCarsForm")
    public ModelAndView addCarsForm() {
        ModelAndView mav = new ModelAndView("add-cars");
        Cars newCars = new Cars();
        mav.addObject("cars", newCars);
        return mav;
    }

    @PostMapping("/saveCars")
    public String saveCars(@ModelAttribute Cars cars) {
        cars_service.saveCars(cars);
        return "redirect:/list/cars";
    }

    @GetMapping("/showUpdateFormCars")
    public ModelAndView showUpdateFormCars(@RequestParam Long carsId) {
        ModelAndView mav = new ModelAndView("add-Cars");
        Cars car = cars_service.searchCars(carsId);
        mav.addObject("cars", car);
        return mav;
    }

    @GetMapping("/deleteCars")
    public String deleteCars(@RequestParam Long carsId) {
        cars_service.deleteCars(carsId);
        return "redirect:/list/cars";
    }

    @GetMapping("/view_attr_car")
    public ModelAndView view_attr_car(@RequestParam Long carsId) {
        ModelAndView mav = new ModelAndView("view_attr");
        Cars car = cars_service.searchCars(carsId);
        mav.addObject("car", car);
        return mav;
    }


}
