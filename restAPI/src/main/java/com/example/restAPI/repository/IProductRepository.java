package com.example.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restAPI.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

}
