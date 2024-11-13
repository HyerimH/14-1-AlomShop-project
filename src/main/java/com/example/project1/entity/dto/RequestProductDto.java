package com.example.project1.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestProductDto {

    String name;

    String description;

    Integer price;

    Integer stock;
}
