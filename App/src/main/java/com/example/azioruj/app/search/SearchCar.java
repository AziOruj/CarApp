package com.example.azioruj.app.search;

import lombok.Data;

@Data
public class SearchCar {
   private String name;
   private String model;
   private String city;
   private Integer minYear;
   private Integer maxYear;
   private Double minPrice;
   private Double maxPrice;
   private Boolean credit;
   private Boolean barter;
}
