package com.example.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "categoty_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "category_name")
    String name;

    public Category(String name) {
        this.name = name;
    }

    //상품에 카테고리 추가하고 상품 설정
    public Category setProduct(Product product){
        this.product = product;
        return this;
    }
}
