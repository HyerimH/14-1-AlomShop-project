package com.example.project1.entity.dto;

import lombok.Data;

@Data
public class RequestCategoryDto {
    String name;

    public RequestCategoryDto() {
    }

    public RequestCategoryDto(String name) {
        this.name = name;
    }
}
