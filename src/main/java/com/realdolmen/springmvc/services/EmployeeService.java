package com.realdolmen.springmvc.services;

import com.realdolmen.springmvc.models.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> getAllEmployees();
     void addEmployee(Employee employee);
     void deleteById(int id);
     Employee findById(int id);
     void update(Employee employee);
}

