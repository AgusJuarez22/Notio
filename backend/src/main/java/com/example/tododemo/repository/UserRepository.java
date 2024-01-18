package com.example.tododemo.repository;

import com.example.tododemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, java.util.UUID> {
}
