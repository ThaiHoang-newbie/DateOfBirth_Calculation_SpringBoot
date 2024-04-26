package com.example.demo1.controller;

import com.example.demo1.model.EmployeeDto;
import com.example.demo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/search")
    public List<EmployeeDto> getEmployeesByName(@RequestParam("name") String name){
        return employeeService.getEmployeesByName(name);
    }

    @PostMapping("/employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto.getName(), employeeDto.getDateOfBirth());
    };

    @PutMapping("/employee")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeDto.getId(), employeeDto.getName(), employeeDto.getDateOfBirth());
    }

    @DeleteMapping("/employee")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.deleteEmployee(employeeDto.getId());
    }
}