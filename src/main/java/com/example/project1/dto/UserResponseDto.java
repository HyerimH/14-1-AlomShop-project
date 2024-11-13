package com.example.project1.dto;

import com.example.project1.entity.User;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String username;
    private final Integer age;
    private final String email;
    private final LocalDateTime createdAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
