package com.example.project1.service;

import com.example.project1.entity.Cart;
import com.example.project1.entity.Category;
import com.example.project1.entity.Product;
import com.example.project1.entity.User;
import com.example.project1.dto.CartDto;
import com.example.project1.repository.CartRepository;
import com.example.project1.repository.CategoryRepository;
import com.example.project1.repository.ProductRepository;
import com.example.project1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository CategoryRepository;

    public CartDto addProductToCart(CartDto cartDto) {
        User user = userRepository.findById(cartDto.getId()).orElseThrow();
        Product product = productRepository.findById(cartDto.getProductId()).orElseThrow();

        Category Category = CategoryRepository.findById(cartDto.getProductCategoryId()).orElseThrow();


        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setProductCategory(Category);

        return new CartDto(cartRepository.save(cart));
    }

    public List<CartDto> getCartItems(Long userId, Long productId, Long productCategoryId) {
        return cartRepository.findByUserIdAndProductIdAndProductCategoryId(userId, productId, productCategoryId)
                .stream()
                .map(CartDto::new)
                .collect(Collectors.toList());
    }

    public void removeProductsFromCart(List<Long> cartItemIds) {
        cartRepository.deleteAllById(cartItemIds);
    }
}
