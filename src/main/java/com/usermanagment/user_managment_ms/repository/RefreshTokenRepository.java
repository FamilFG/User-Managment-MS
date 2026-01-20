package com.usermanagment.user_managment_ms.repository;

import com.usermanagment.user_managment_ms.entity.RefreshTokenEntity;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository  extends JpaRepository<RefreshTokenEntity, UUID> {
    Optional<RefreshTokenEntity> findByToken(String token);

    List<RefreshTokenEntity> findByUser(UserEntity user);

}

