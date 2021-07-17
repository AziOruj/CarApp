package com.example.azioruj.app.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, Integer> year;
	public static volatile SingularAttribute<Car, String> city;
	public static volatile SingularAttribute<Car, Double> price;
	public static volatile SingularAttribute<Car, String> name;
	public static volatile SingularAttribute<Car, Boolean> barter;
	public static volatile SingularAttribute<Car, String> model;
	public static volatile SingularAttribute<Car, Long> id;
	public static volatile SingularAttribute<Car, Boolean> credit;

	public static final String YEAR = "year";
	public static final String CITY = "city";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String BARTER = "barter";
	public static final String MODEL = "model";
	public static final String ID = "id";
	public static final String CREDIT = "credit";

}

