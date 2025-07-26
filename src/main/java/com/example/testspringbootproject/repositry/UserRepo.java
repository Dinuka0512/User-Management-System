package com.example.testspringbootproject.repositry;


import com.example.testspringbootproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> searchUserByNameContainsIgnoreCase(String name);
}
