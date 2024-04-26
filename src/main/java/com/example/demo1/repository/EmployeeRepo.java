package com.example.demo1.repository;

import com.example.demo1.entities.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
