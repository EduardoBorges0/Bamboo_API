package com.bamboo.api.domain.dto.user;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String role;
    private String username;
    private String email;
    private String password;
}
