package com.realdolmen.springmvc.controllers;

import com.realdolmen.springmvc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.realdolmen.springmvc.services.EmployeeService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public ModelAndView searchEmployees(ModelMap model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return new ModelAndView("employeeListDisplay", model);
    }

    @GetMapping("/add")
    public ModelAndView showAddView(ModelMap modelMap) {
        return new ModelAndView("addEmployee", modelMap);
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/employee/getAllEmployees");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteById(id);
        return new ModelAndView("redirect:/employee/getAllEmployees");
    }
    @GetMapping("/{id}/edit") // <---- Creates url in the form of localhost:port/employee/{id}/edit
    public ModelAndView showEditPage(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("employee", employeeService.findById(id));
        return new ModelAndView("editEmployee", modelMap);

    }
    @PostMapping("/edit")
    public ModelAndView save(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return new ModelAndView("redirect:/employee/getAllEmployees");
    }
}