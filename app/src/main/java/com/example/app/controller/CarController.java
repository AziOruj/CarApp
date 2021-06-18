package com.example.app.controller;

import com.example.app.dto.CarDto;
import com.example.app.dto.CreateCarDto;
import com.example.app.exception.CarNotFoundException;
import com.example.app.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    @GetMapping
    public List<CarDto> getAll (){
        log.trace("Get car by All");
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> get (@PathVariable Long id){
        log.trace("Get car by id {}",id);
        try{
            return ResponseEntity.ok(carService.getCar(id));
        }catch (CarNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping
    public ResponseEntity<CarDto> create (@RequestBody CreateCarDto dto ){
        log.trace("Create car body {}",dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(dto));

    }
    @PutMapping ("/{id}")
    public ResponseEntity<CarDto> update (@PathVariable Long id, @RequestBody CreateCarDto dto ){
        log.trace("Update car by id {} body {}",id,dto);
       try {
           return ResponseEntity.ok(carService.updateCar(id,dto));
       }catch (CarNotFoundException e){
           return  ResponseEntity.notFound().build();
       }


    }
    @DeleteMapping ("/{id}")
    public ResponseEntity delete (@PathVariable Long id ){
        log.trace("Delete car by id {}",id);
        try {
            carService.deleteCar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (CarNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

