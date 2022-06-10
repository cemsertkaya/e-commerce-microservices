package com.archTech.AuthService.repository;

import com.archTech.AuthService.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthUser,Long> {
    AuthUser findUserByEmail(String email);
}
