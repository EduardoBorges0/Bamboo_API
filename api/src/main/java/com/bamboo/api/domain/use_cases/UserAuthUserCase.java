package com.bamboo.api.domain.use_cases;

import com.bamboo.api.data.model.UserEntity;
import com.bamboo.api.data.repositories.UserRepositories;
import com.bamboo.api.domain.dto.user.AuthUserDTO;
import com.bamboo.api.domain.mapper.user.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuthUserCase {
    private final UserRepositories userRepositories;
    private final UserAuthMapper userAuthMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserAuthUserCase(UserRepositories userRepositories,
                            UserAuthMapper userAuthMapper) {
        this.userRepositories = userRepositories;
        this.userAuthMapper = userAuthMapper;
    }

    public ResponseEntity<?> invoke(String email, String password) {
        Optional<UserEntity> optionalUser = userRepositories.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("Email ou senha inválidos");
        }

        AuthUserDTO authUserDTOMapper = userAuthMapper.toDTO(optionalUser.get());

        if (passwordEncoder.matches(password, authUserDTOMapper.getPassword())) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("Email ou senha inválidos");
    }

}
