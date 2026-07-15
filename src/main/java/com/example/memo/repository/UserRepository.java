package com.example.memo.repository;

import com.example.memo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {}
