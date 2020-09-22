package com.realdolmen.springmvc.doa;

import com.realdolmen.springmvc.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    int addEmployee(Employee employee);
    void deleteById(int id);
    void update(Employee employee);
    Employee findById(int id);
}