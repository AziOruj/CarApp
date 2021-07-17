package com.example.azioruj.app.dto;

import lombok.Data;

@Data
public class CarCreateDto {
    private String name;
    private String model;
    private Integer year;
    private Double price;
    private String city;
    private Boolean credit;
    private Boolean barter;
}
