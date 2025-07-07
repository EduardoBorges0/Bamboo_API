package com.bamboo.api.presentation.controller;

import com.bamboo.api.config.Roles;
import com.bamboo.api.domain.dto.user.AuthUserDTO;
import com.bamboo.api.domain.dto.user.RegisterUserDTO;
import com.bamboo.api.domain.use_cases.RegisterUserUseCase;
import com.bamboo.api.domain.use_cases.UserAuthUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private RegisterUserUseCase registerUserUseCase;
    private UserAuthUserCase userAuthUserCase;
    public AuthController(RegisterUserUseCase registerUserUseCase, UserAuthUserCase userAuthUserCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.userAuthUserCase = userAuthUserCase;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO registerUserDTO) {
        if(registerUserDTO.getRole().isBlank()){
            registerUserDTO.setRole(Roles.BASIC.name());
        }
       return registerUserUseCase.invoke(registerUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUserDTO authUserDTO) {
        return userAuthUserCase.invoke(authUserDTO.getEmail(), authUserDTO.getPassword());
    }
}
