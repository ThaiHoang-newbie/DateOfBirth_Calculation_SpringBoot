package com.example.demo1.controller;

import com.example.demo1.model.EmployeeDto;
import com.example.demo1.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto.getName(), employeeDto.getDateOfBirth());
    }
}
