package com.realdolmen.springmvc.controllers;

import com.realdolmen.springmvc.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @RequestMapping(value = "/getAllAnimals", method = RequestMethod.GET)
    public ModelAndView searchAnimals(ModelMap model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return new ModelAndView("animalListDisplay", model);
    }
}
