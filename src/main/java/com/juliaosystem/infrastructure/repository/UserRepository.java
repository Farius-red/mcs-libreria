package com.juliaosystem.infrastructure.repository;

import com.juliaosystem.infrastructure.entitis.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
