package com.example.project1.controller;


import com.example.project1.entity.Category;
import com.example.project1.entity.Product;
import com.example.project1.entity.dto.RequestCategoryDto;
import com.example.project1.entity.dto.RequestProductDto;
import com.example.project1.repository.CategoryRepository;
import com.example.project1.service.CategoryService;
import com.example.project1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping()
    public Product addProduct(@RequestBody RequestProductDto product){
        return productService.createProduct(product);
    }

    @GetMapping()
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("상품제거완료");
    }

    /*
    카테고리 추가
    id:상품번호
    */
    @PostMapping("/category")
    public void addCategory(@RequestParam("productId") Long id, @RequestBody RequestCategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        productService.addCategory(id, category);
    }

    //상품의 카테고리 삭제, 파라미터로 상품,카테고리 id전달
    @DeleteMapping("/category")
    public void deleteCategory(@RequestParam("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
