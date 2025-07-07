package com.bamboo.api.domain.mapper.user;

import com.bamboo.api.data.model.UserEntity;
import com.bamboo.api.domain.dto.user.AuthUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserAuthMapper {
    public UserAuthMapper() {}

    public AuthUserDTO toDTO(UserEntity user) {
        AuthUserDTO authUserDto = new AuthUserDTO();
        authUserDto.setEmail(user.getEmail());
        authUserDto.setPassword(user.getPassword());
        return authUserDto;
    }
    public UserEntity toEntity(AuthUserDTO authDTO) {
        UserEntity user = new UserEntity();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return user;
    }
}
