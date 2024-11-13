package com.example.project1.service;

import com.example.project1.entity.Category;
import com.example.project1.entity.Product;
import com.example.project1.entity.dto.RequestProductDto;
import com.example.project1.repository.CategoryRepository;
import com.example.project1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product createProduct(RequestProductDto productDto){
        Product product = new Product(productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getStock());
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }
    public Product addCategory(Long id,Category category){
        Product product = productRepository.findById(id).get();
        return product.addCategory(category);
    }



}
