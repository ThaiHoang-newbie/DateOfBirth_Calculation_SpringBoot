package com.example.demo1.model;

import java.util.Date;

public class EmployeeDto {

    Long id;
    String name;
    Date dateOfBirth;
    String tuoiamlich;
    String mang;

    public EmployeeDto(Long id, String name, Date dateOfBirth, String tuoiamlich, String mang) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.tuoiamlich = tuoiamlich;
        this.mang = mang;
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

    public String getTuoiamlich() {
        return tuoiamlich;
    }

    public void setTuoiamlich(String tuoiamlich) {
        this.tuoiamlich = tuoiamlich;
    }

    public String getMang() {
        return mang;
    }

    public void setMang(String mang) {
        this.mang = mang;
    }
}
