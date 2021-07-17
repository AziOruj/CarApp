package com.example.azioruj.app.controller;

import com.example.azioruj.app.dto.CarDto;
import com.example.azioruj.app.exception.NotCarFound;
import com.example.azioruj.app.search.SearchCar;
import com.example.azioruj.app.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cars/search")
public class CarSearchController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity< List<CarDto> > searchCar(@RequestBody SearchCar searchCar){
        log.info("Search by car{}",searchCar);
        try {
            return ResponseEntity.ok(carService.searchSpecify(searchCar));
        }catch (NotCarFound ex){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
