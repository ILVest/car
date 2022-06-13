package Car_dealership.Cars.Controller;

import Car_dealership.Cars.Models.Cars_dealership;
import Car_dealership.Cars.Services.Cars_dealership_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Cars_dealership_Controller {

    @Autowired
    private Cars_dealership_Service cars_dealership_service;

    @GetMapping({"/list/cars_dealership","/"})
    public ModelAndView getAllCars_dealership() {
        ModelAndView mav = new ModelAndView("list-cars_dealership");
        mav.addObject("cars_dealership", cars_dealership_service.getCars_dealership());
        return mav;
    }

    @GetMapping("/addCars_dealershipForm")
    public ModelAndView addCars_dealershipForm() {
        ModelAndView mav = new ModelAndView("add-cars_dealership");
        Cars_dealership newCars_dealership = new Cars_dealership();
        mav.addObject("cars_dealership", newCars_dealership);
        return mav;
    }

    @PostMapping("/saveCars_dealership")
    public String saveCars_dealership(@ModelAttribute Cars_dealership cars_dealership) {
        cars_dealership_service.saveCars_dealership(cars_dealership);
        return "redirect:/list/cars_dealership";
    }

    @GetMapping("/showUpdateFormCars_dealership")
    public ModelAndView showUpdateFormCars_dealership(@RequestParam Long cars_dealershipId) {
        ModelAndView mav = new ModelAndView("add-Cars_dealership");
        Cars_dealership cars_dealership = cars_dealership_service.searchCars_dealership(cars_dealershipId);
        mav.addObject("cars_dealership", cars_dealership);
        return mav;
    }

    @GetMapping("/deleteCars_dealership")
    public String deleteCars_dealership(@RequestParam Long cars_dealershipId) {
        cars_dealership_service.deleteCars_dealership(cars_dealershipId);
        return "redirect:/list/cars_dealership";
    }


}
