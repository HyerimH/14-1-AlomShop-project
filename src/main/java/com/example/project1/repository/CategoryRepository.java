package com.example.project1.repository;

import com.example.project1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
