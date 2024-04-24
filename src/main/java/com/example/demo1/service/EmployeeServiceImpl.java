package com.example.demo1.service;

import com.example.demo1.entities.Employee;
import com.example.demo1.model.EmployeeDto;
import com.example.demo1.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<EmployeeDto> getEmployees() {
        return employeeRepo.findAll().stream()
                .map(obj -> new EmployeeDto(obj.getName(), obj.getDateOfBirth()))
                .collect(Collectors.toList());
//        var employees = employeeRepo.findAll();
//        List<EmployeeDto> employeeList = new ArrayList<>();
//
//        employees.forEach(obj -> {
//            EmployeeDto item = new EmployeeDto();
//            item.setName(obj.getName());
//            item.setDateOfBirth(obj.getDateOfBirth());
//            employeeList.add(item);
//        });
//        return employeeList;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id){
        var item = employeeRepo.findById(id).orElseThrow();
        return  new EmployeeDto(item.getName(), item.getDateOfBirth());
    }

    @Override
    public void createEmployee(String name, Date dayOfBirth) {
        Employee newUser = new Employee();
        newUser.setName(name);
        newUser.setDateOfBirth(dayOfBirth);

        employeeRepo.save(newUser);
    }

}
