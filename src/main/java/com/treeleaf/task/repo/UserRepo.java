package com.treeleaf.task.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treeleaf.task.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUserName(String username);

}
