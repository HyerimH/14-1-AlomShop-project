package com.example.project1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    Cart cart;

    //orphanRemoval = true-> 관계가 끊어지면 db의 자식 엔티티는 제거됨
    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Category> categoryList = new ArrayList<>();

    @Column(name = "prooduct_name")
    String name;

    @Lob
    String description;

    Integer price;

    Integer stock;

    public Product(String name, String description, Integer price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product addCategory(Category category){
        category.setProduct(this);
        this.categoryList.add(category);
        return this;
    }
    public Product deleteCategory(Category category){
        categoryList.remove(category);
        return this;
    }
}


