package com.example.project1.repository;

import com.example.project1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}