package com.example.app.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String model;
    private String type;
    private String color;
    private Integer year;
}
