package com.springboot.library.repository;

import com.springboot.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    public void deleteByUsername(String username);
}
