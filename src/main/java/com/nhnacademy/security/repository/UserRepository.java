package com.nhnacademy.security.repository;

import com.nhnacademy.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
