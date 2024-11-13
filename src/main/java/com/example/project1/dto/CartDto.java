package com.example.project1.dto;

import com.example.project1.entity.Cart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    private Long id;
    private Long userId;
    private Long productId;
    private Long productCategoryId;

    public CartDto(Cart cart) {
        this.id = cart.getId();
        this.userId = cart.getUser().getId();
        this.productId = cart.getProduct().getId();
        this.productCategoryId = cart.getProductCategory().getId();
    }
}
