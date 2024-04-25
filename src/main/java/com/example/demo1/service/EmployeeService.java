package com.example.demo1.service;

import com.example.demo1.model.EmployeeDto;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployeeById(Long id);

    void createEmployee(String name, Date dayOfBirth);

    void updateEmployee(Long id, String name, Date dayOfBirth);

}
