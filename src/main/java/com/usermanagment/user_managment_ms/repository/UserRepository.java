package com.usermanagment.user_managment_ms.repository;

import com.usermanagment.user_managment_ms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
