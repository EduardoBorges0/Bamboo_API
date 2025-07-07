package com.bamboo.api.data.repositories;

import com.bamboo.api.data.model.UserEntity;
import com.bamboo.api.domain.dto.user.AuthUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
