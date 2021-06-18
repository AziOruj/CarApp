package com.example.app.dto;

import lombok.Data;

@Data
public class CreateCarDto {
    private String model;
    private String type;
    private String color;
    private Integer year;
}
