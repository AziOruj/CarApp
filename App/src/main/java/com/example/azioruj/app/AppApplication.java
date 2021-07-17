package com.example.azioruj.app;

import com.example.azioruj.app.entity.Car;
import com.example.azioruj.app.repository.CarRepository;
import com.example.azioruj.app.search.SearchCar;
import com.example.azioruj.app.service.CarService;
import com.example.azioruj.app.service.CarServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class AppApplication implements CommandLineRunner {
	private final CarRepository carRepository;
	private final CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Car add database");
//		carRepository.findByName(false)
//				.stream()
//				.forEach(System.out::println);
		SearchCar ad = new SearchCar();
		ad.setCity("BAaku");
		carService.searchSpecify(ad);

	}
}
