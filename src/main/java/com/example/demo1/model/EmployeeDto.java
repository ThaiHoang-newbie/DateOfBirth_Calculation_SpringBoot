package com.example.demo1.model;

import java.util.Date;

public class EmployeeDto {

    Long id;
    String name;
    Date dateOfBirth;
    String chineseZodiac;
    String element;

    public EmployeeDto(Long id, String name, Date dateOfBirth, String chineseZodiac, String element) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.chineseZodiac = chineseZodiac;
        this.element = element;
    }

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
