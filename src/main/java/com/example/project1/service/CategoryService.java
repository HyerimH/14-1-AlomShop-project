package com.example.project1.service;

import com.example.project1.entity.Category;
import com.example.project1.entity.dto.RequestCategoryDto;
import com.example.project1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(RequestCategoryDto categoryDto){
        return categoryRepository.save(new Category(categoryDto.getName()));
    }
    public ResponseEntity<String> deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
        return ResponseEntity.ok("delete");
    }


    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

}
