package com.example.azioruj.app.repository;

import com.example.azioruj.app.dto.CarDto;
import com.example.azioruj.app.entity.Car;
import com.example.azioruj.app.search.SearchCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> , JpaSpecificationExecutor {
}
