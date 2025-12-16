package com.springdatajpa.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.spring_data_jpa.entity.Product;


@Repository
public interface productRepository  extends JpaRepository<Product, Long>{

	boolean existsByName(String name);

}
