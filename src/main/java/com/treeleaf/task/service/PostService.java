package com.treeleaf.task.service;

import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.treeleaf.task.dto.PostDto;
import com.treeleaf.task.entity.Post;
import com.treeleaf.task.exception.PostNotFoundException;
import com.treeleaf.task.repo.PostRepo;


@Service
public class PostService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PostRepo postRepo;
	
	
	 
	    public List<PostDto> showAllPosts() {
	        List<Post> posts = postRepo.findAll();
	        return posts.stream().map(this::mapFromPostToDto).collect(toList());
	    }

	    
	    public void createPost(PostDto postDto) {
	        Post post = mapFromDtoToPost(postDto);
	        postRepo.save(post);
	    }

	    
	    public PostDto readSinglePost(Long id) {
	        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
	        return mapFromPostToDto(post);
	    }

	    private PostDto mapFromPostToDto(Post post) {
	        PostDto postDto = new PostDto();
	        postDto.setimage(post.getId());
	        postDto.setTitle(post.getTitle());
	        postDto.setContent(post.getContent());
	        return postDto;
	    }

	    private Post mapFromDtoToPost(PostDto postDto) {
	        Post post = new Post();
	        post.setTitle(postDto.getTitle());
	        post.setContent(postDto.getContent());
	        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
	        return post;
	    }
	}