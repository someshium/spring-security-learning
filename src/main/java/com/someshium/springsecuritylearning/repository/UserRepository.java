package com.someshium.springsecuritylearning.repository;

import com.someshium.springsecuritylearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
    SELECT u from User u where u.username=:username 
""")
    Optional<User> findUserByUsername(String username);
}
