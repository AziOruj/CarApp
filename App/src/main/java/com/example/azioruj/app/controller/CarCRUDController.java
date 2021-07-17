package com.example.azioruj.app.controller;

import com.example.azioruj.app.dto.CarCreateDto;
import com.example.azioruj.app.dto.CarDto;
import com.example.azioruj.app.exception.NotCarFound;
import com.example.azioruj.app.repository.CarRepository;
import com.example.azioruj.app.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/cars")
public class CarCRUDController {
    private final CarService carService;
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> get(@PathVariable Long id){
        try {
            return ResponseEntity.ok(carService.getCar(id));
        }catch (NotCarFound ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping
    public CarDto create(@RequestBody CarCreateDto car){
        return carService.create(car);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CarDto>  update (@PathVariable Long id, @RequestBody CarCreateDto car){
        try {
            return ResponseEntity.ok(carService.update(id, car));
        }catch (NotCarFound e){
           return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            carService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (NotCarFound e){
            return ResponseEntity.notFound().build();
        }
    }
}
