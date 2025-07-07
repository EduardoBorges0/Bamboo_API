package com.bamboo.api.domain.use_cases;

import com.bamboo.api.data.model.MessageError;
import com.bamboo.api.data.model.UserEntity;
import com.bamboo.api.data.repositories.UserRepositories;
import com.bamboo.api.domain.dto.user.AuthUserDTO;
import com.bamboo.api.domain.dto.user.RegisterUserDTO;
import com.bamboo.api.domain.mapper.user.UserRegisterMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegisterUserUseCase {

    private UserRepositories userRepositories;
    private UserRegisterMapper userRegisterMapper;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public RegisterUserUseCase(UserRepositories userRepositories, UserRegisterMapper userRegisterMapper) {
        this.userRepositories = userRepositories;
        this.userRegisterMapper = userRegisterMapper;
    }

    public ResponseEntity<?> invoke(RegisterUserDTO registerUserDTO) {
        Optional<UserEntity> existingUser = userRepositories.findByEmail(registerUserDTO.getEmail());

        if (existingUser.isPresent()) {
            MessageError message = new MessageError();
            message.setMessage("User already exists");
            message.setCode(400);
            return ResponseEntity.status(400).body(message);
        }

        UserEntity userEntity = userRegisterMapper.toEntity(registerUserDTO);
        userEntity.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        userRepositories.save(userEntity);

        MessageError message = new MessageError();
        message.setCode(201);
        message.setMessage("User created");
        return ResponseEntity.status(201).body(message);
    }

}
