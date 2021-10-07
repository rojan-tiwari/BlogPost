package com.treeleaf.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treeleaf.task.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
