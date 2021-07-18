package com.example.azioruj.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
@NamedQuery(name="Car.findByName",query = "SELECT s from Car s WHERE LOWER(s.credit)=LOWER(?1)")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private Integer year;
    private Double price;
    private String city;
    private Boolean credit;
    private Boolean barter;

}
