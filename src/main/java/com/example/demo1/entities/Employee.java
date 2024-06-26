package com.example.demo1.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Employee {
    @Column
    String name;

    @Column(name = "date_of_birth")
    Date dateOfBirth;

    @Column(name = "chinese_zodiac")
    String chineseZodiac;

    @Column(name = "element")
    String element;
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
    Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChineseZodiac() {
        return chineseZodiac;
    }

    public void setChineseZodiac(String chineseZodiac) {
        this.chineseZodiac = chineseZodiac;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
