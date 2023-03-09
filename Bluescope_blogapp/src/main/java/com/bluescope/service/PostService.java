package com.bluescope.service;

import java.util.List;

import com.bluescope.entity.Post;
import com.bluescope.exception.PostException;
import com.bluescope.exception.UserException;

public interface PostService {
	
	public List<Post> getAllPosts() throws PostException;
	
	public Post getPostById(String uuid, int postId) throws PostException,UserException;
	
	public Post createPost(String uuid, Post post) throws PostException,UserException;
	
	 public Post updatePost(String uuid,Post postDetails) throws PostException,UserException;
	 
	 public Post deletePost(String uuid, Integer id) throws PostException,UserException;

	

}
