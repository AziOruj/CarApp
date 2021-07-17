package com.example.azioruj.app.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String name;
    private String model;
    private Integer year;
    private Double price;
    private String city;
    private Boolean credit;
    private Boolean barter;
}
