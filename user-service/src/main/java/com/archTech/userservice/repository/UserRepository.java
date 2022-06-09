package com.archTech.userservice.repository;

import com.archTech.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByUserId(Long userId);

    User findByEmail(String email);
}
