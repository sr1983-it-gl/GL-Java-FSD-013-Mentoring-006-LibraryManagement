package com.greatlearning.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.librarymanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
	@Query("SELECT u FROM User u WHERE u.username = ?1")
    User getUserByUsername(String username);
}

