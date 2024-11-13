package com.example.project1.repository;

import com.example.project1.entity.Category;
import com.example.project1.entity.Product;
import com.example.project1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductRepositoryTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Rollback(value = false)
    void createProductAndCategory(){
        Product product = new Product("사탕", "딸기맛", 100, 100);
        productRepository.save(product);
        Category category1 = new Category("과자류");
        Category category2 = new Category("사탕류");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        product.addCategory(category1);
        product.addCategory(category2);
    }
}