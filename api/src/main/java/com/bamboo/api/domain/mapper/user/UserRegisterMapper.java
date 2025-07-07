package com.bamboo.api.domain.mapper.user;

import com.bamboo.api.data.model.UserEntity;
import com.bamboo.api.domain.dto.user.RegisterUserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {
    public UserRegisterMapper() {}
   public RegisterUserDTO toDTO(UserEntity user) {
       RegisterUserDTO registerUserDto = new RegisterUserDTO();
        registerUserDto.setRole(user.getRole());
        registerUserDto.setUsername(user.getUsername());
        registerUserDto.setEmail(user.getEmail());
        registerUserDto.setPassword(user.getPassword());
        return registerUserDto;
    }
    public UserEntity toEntity(RegisterUserDTO registerDTO){
       UserEntity user = new UserEntity();
        user.setRole(registerDTO.getRole());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }
}
