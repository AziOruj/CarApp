package com.example.azioruj.app.service;

import com.example.azioruj.app.dto.CarCreateDto;
import com.example.azioruj.app.dto.CarDto;
import com.example.azioruj.app.search.SearchCar;

import java.util.List;

public interface CarService {
    CarDto create (CarCreateDto car);
    CarDto getCar(Long id);
    CarDto update(Long id ,CarCreateDto car);
    String delete(Long id);
   // List< CarDto> searchSpecification(SearchCar searchCar);
    List< CarDto> searchSpecify(SearchCar searchCar);
}
