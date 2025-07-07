package com.bamboo.api.domain.dto.user;

import lombok.Data;

@Data
public class AuthUserDTO {
    private String email;
    private String password;
}
