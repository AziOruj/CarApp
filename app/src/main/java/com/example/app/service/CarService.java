package com.example.app.service;

import com.example.app.dto.CarDto;
import com.example.app.dto.CreateCarDto;

import java.util.List;

public interface CarService {
     CarDto createCar(CreateCarDto dto);
     CarDto updateCar(Long id, CreateCarDto dto);
     void deleteCar(Long id);
     CarDto getCar(Long id);
     List<CarDto> getAllCars();
}
