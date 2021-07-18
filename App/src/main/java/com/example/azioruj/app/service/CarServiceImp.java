package com.example.azioruj.app.service;

import com.example.azioruj.app.dto.CarCreateDto;
import com.example.azioruj.app.dto.CarDto;
import com.example.azioruj.app.entity.Car;
import com.example.azioruj.app.entity.Car_;
import com.example.azioruj.app.exception.NotCarFound;
import com.example.azioruj.app.repository.CarRepository;
import com.example.azioruj.app.search.SearchCar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImp implements  CarService{
    private final EntityManager em;
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    @Override
    public CarDto create(CarCreateDto car) {
        log.info("Create new car {}",car);
       CarDto dto=mapper.map(carRepository.save(mapper.map(car,Car.class)),CarDto.class);
        return dto;
    }

    @Override
    public CarDto getCar(Long id) {
        log.info("Get car by id {}",id);
        return mapper.map(carRepository.findById(id).orElseThrow(NotCarFound::new),CarDto.class);
    }

    @Override
    public CarDto update(Long id, CarCreateDto car) {
        log.info("Update by id {},{}",id, car);
        carRepository.findById(id).orElseThrow(NotCarFound::new);
        CarDto dto = mapper.map(car,CarDto.class);
        dto.setId(id);
        return dto;
    }

    @Override
    public String delete(Long id) {
        log.info("Deleted car by id {}",id);
        carRepository.findById(id).orElseThrow(NotCarFound::new);
        carRepository.deleteById(id);
        return "Deleted car by id: "+id;
    }

//    @Override
//    public List<CarDto> searchSpecification(SearchCar searchCar) {
//        CriteriaBuilder cb =em.getCriteriaBuilder();
//        CriteriaQuery<Car> cq =cb.createQuery(Car.class);
//        Root<Car> root =cq.from(Car.class);
//        List<Predicate> predicates =new ArrayList<>();
//        if (searchCar.getName() != null){
//            predicates.add(cb.equal(root.get(Car_.NAME),searchCar.getName()));
//        }
//        if (searchCar.getModel() != null){
//            predicates.add(cb.equal(root.get(Car_.MODEL),searchCar.getModel()));
//        }
//        if (searchCar.getCity() != null){
//            predicates.add(cb.equal(root.get(Car_.CITY),searchCar.getCity()));
//        }
//        if (searchCar.getMinPrice() != null){
//            predicates.add(cb.greaterThanOrEqualTo(root.get(Car_.PRICE),searchCar.getMinPrice()));
//        }
//        if (searchCar.getMaxPrice() != null){
//            predicates.add(cb.lessThanOrEqualTo(root.get(Car_.PRICE),searchCar.getMaxPrice()));
//        }
//        if (searchCar.getMinYear() != null){
//            predicates.add(cb.greaterThanOrEqualTo(root.get(Car_.YEAR),searchCar.getMinYear()));
//        }
//        if (searchCar.getMaxYear() != null){
//            predicates.add(cb.lessThanOrEqualTo(root.get(Car_.YEAR),searchCar.getMaxYear()));
//        }
//        if (searchCar.getCredit() != null){
//            predicates.add(cb.equal(root.get(Car_.CREDIT),searchCar.getCredit()));
//        }
//        if (searchCar.getBarter() != null){
//            predicates.add(cb.equal(root.get(Car_.BARTER),searchCar.getBarter()));
//        }
//        cq.where(predicates.toArray(new Predicate[predicates.size()]));
//        TypedQuery<Car> query =em.createQuery(cq);
//        List<CarDto> carDto= mapper.map(query.getResultList(),new TypeToken<List<CarDto>>(){}.getType());
//
//        return carDto;
//    }

    public List<CarDto> searchSpecify(SearchCar searchCar){
        try {
            //noinspection unchecked
            List<Car> car = carRepository.findAll(
                    (root, query, cb) ->
                    {
                List<Predicate> predicates = new ArrayList<>();
                if (searchCar.getName() != null) {
                    predicates.add(cb.equal(root.get(Car_.NAME), searchCar.getName()));
                }
                if (searchCar.getModel() != null) {
                    predicates.add(cb.equal(root.get(Car_.MODEL), searchCar.getModel()));
                }
                if (searchCar.getCity() != null) {
                    predicates.add(cb.equal(root.get(Car_.CITY), searchCar.getCity()));
                }

                if (searchCar.getMinPrice() != null) {
                    //noinspection unchecked
                    predicates.add(cb.greaterThanOrEqualTo(root.get(Car_.PRICE), searchCar.getMinPrice()));
                }
                if (searchCar.getMaxPrice() != null) {
                    //noinspection unchecked
                    predicates.add(cb.lessThanOrEqualTo(root.get(Car_.PRICE), searchCar.getMaxPrice()));
                }
                if (searchCar.getMinYear() != null) {
                    //noinspection unchecked
                    predicates.add(cb.greaterThanOrEqualTo(root.get(Car_.YEAR), searchCar.getMinYear()));
                }
                if (searchCar.getMaxYear() != null) {
                    //noinspection unchecked
                    predicates.add(cb.lessThanOrEqualTo(root.get(Car_.YEAR), searchCar.getMaxYear()));
                }
                if (searchCar.getCredit() != null) {
                    predicates.add(cb.equal(root.get(Car_.CREDIT), searchCar.getCredit()));
                }
                if (searchCar.getBarter() != null) {
                    predicates.add(cb.equal(root.get(Car_.BARTER), searchCar.getBarter()));
                }
                return cb.or(predicates.toArray(new Predicate[0]));

                     });
                     return mapper.map(car,new TypeToken<List<CarDto>>(){}.getType());

            }catch (RuntimeException exception) {
                  throw new NotCarFound();
               }
    }
}
