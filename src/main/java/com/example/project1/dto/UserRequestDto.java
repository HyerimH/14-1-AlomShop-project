package com.example.project1.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = "사용자명은 필수입니다")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다")
    private String password;

    private Integer age;

    @Email(message = "올바른 이메일 형식이어야 합니다")
    @NotBlank(message = "이메일은 필수입니다")
    private String email;
}

