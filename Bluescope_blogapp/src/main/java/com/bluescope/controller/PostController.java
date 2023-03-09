package com.bluescope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluescope.entity.Post;
import com.bluescope.exception.PostException;
import com.bluescope.exception.UserException;
import com.bluescope.service.PostService;

@RestController
@RequestMapping("/blogpost")
public class PostController {
	
	@Autowired
	private PostService pos;
	
	@GetMapping("/post")
	public ResponseEntity<Post> getAllProductHandler() throws PostException{
		Post post=(Post) pos.getAllPosts();
		return new ResponseEntity<Post>(post, HttpStatus.OK); 
	}


    @GetMapping("/getpostbyid/{id}/{key}")
    public ResponseEntity<Post> getPostByIdHandler(@PathVariable("key")String key,@PathVariable("id") Integer postId) throws PostException, UserException{
        Post post1 = pos.getPostById(key, postId);
        return new ResponseEntity<Post>(post1, HttpStatus.OK); 
    }
    
    @PostMapping("/createpost/{key}")
    public ResponseEntity<Post> createPostHandler(@PathVariable("key")String key,@RequestBody Post post) throws PostException, UserException{
        Post post2 = pos.createPost(key, post);
        return new ResponseEntity<Post>(post2, HttpStatus.OK); 
    }
    
    @PostMapping("/updatepost/{key}")
    public ResponseEntity<Post> updatePostHandler(@PathVariable("key")String key,@RequestBody Post post) throws PostException, UserException{
        Post post3 = pos.updatePost(key, post);
        return new ResponseEntity<Post>(post3, HttpStatus.OK); 
    }

    @DeleteMapping("/deletepost/{key}")
    public ResponseEntity<Void> removeProductHandler(@PathVariable("key")String key,@PathVariable("id") Integer postId) throws PostException, UserException{
        pos.deletePost(key, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	

}
