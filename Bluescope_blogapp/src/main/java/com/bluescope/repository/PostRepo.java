package com.bluescope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluescope.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByAuthor(String author);

}
