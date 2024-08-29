package com.avik.spring_boot_rest_jobPost.repo;

import com.avik.spring_boot_rest_jobPost.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
