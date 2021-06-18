package com.example.app.service;

import com.example.app.dto.CarDto;
import com.example.app.dto.CreateCarDto;
import com.example.app.entity.Car;
import com.example.app.exception.CarNotFoundException;
import com.example.app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;



    @Override
    public CarDto getCar(Long id) {
        log.trace("Get car by id {}",id);
        return modelMapper.map(carRepository.findById(id)
                .orElseThrow(CarNotFoundException::new), CarDto.class);
    }
    @Override
    public CarDto createCar(CreateCarDto dto) {
        log.trace("Create car body {}",dto);
        Car car =carRepository.save(modelMapper.map(dto, Car.class));
        return modelMapper.map(car,CarDto.class);
    }

    @Override
    public CarDto updateCar(Long id, CreateCarDto dto) {
        log.trace("Update car by id {} body {}",id,dto);
        carRepository.findById(id).orElseThrow(CarNotFoundException:: new);
        Car car =modelMapper.map(dto, Car.class);
        car.setId(id);
        carRepository.save(car);
        return modelMapper.map(car, CarDto.class);
    }

    @Override
    public void deleteCar(Long id) {
        log.trace("Delete car by id {}",id);
        carRepository.findById(id).orElseThrow(CarNotFoundException:: new);
        carRepository.deleteById(id);
    }
    @Override
   public List<CarDto> getAllCars(){
        log.trace("Get car by AllCars");
        List<CarDto> carDto= modelMapper.map(carRepository.findAll(),new TypeToken<List<CarDto>>(){}.getType());

        return carDto;
    }

}
