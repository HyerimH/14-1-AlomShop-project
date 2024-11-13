package com.example.project1.repository;

import com.example.project1.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserIdAndProductIdAndProductCategoryId(Long userId, Long productId, Long productCategoryId);
}
