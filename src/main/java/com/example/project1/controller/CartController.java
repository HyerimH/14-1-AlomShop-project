package com.example.project1.controller;

import com.example.project1.dto.CartDto;
import com.example.project1.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니에 상품 추가 (POST /cart)
    @PostMapping
    public CartDto addProductToCart(@RequestBody CartDto cartDto) {
        return cartService.addProductToCart(cartDto);
    }

    // 특정 조건의 장바구니 조회 (GET /cart/{userId}/{productId}/{productCategoryId})
    @GetMapping("/{userId}/{productId}/{productCategoryId}")
    public List<CartDto> getCartItems(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @PathVariable Long productCategoryId) {
        return cartService.getCartItems(userId, productId, productCategoryId);
    }

    // 장바구니에서 상품 제거 (DELETE /cart)
    @DeleteMapping
    public void removeProductsFromCart(@RequestBody List<Long> cartItemIds) {
        cartService.removeProductsFromCart(cartItemIds);
    }
}
