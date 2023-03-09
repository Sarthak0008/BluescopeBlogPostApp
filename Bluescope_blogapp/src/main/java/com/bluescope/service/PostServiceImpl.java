package com.bluescope.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluescope.entity.CurrentUserSession;
import com.bluescope.entity.Post;
import com.bluescope.entity.User;
import com.bluescope.exception.PostException;
import com.bluescope.exception.UserException;
import com.bluescope.repository.CurrentUserSessionRepo;
import com.bluescope.repository.PostRepo;
import com.bluescope.repository.UserRepo;


@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo postrepo;
	
	 @Autowired
	 UserRepo userrepo;
	
	@Autowired
	CurrentUserSessionRepo cusrepo;

	@Override
	public List<Post> getAllPosts() throws PostException {
		
		return postrepo.findAll();
		
	}

	@Override
	public Post getPostById(String uuid, int postId) throws PostException, UserException {
		 CurrentUserSession loginUser = cusrepo.findByUUID(uuid);
			
			if(loginUser == null) {
				throw new UserException("User not found");
			}
			
			
			Optional<Post> userpost = this.postrepo.findById(postId);
			
			if(userpost.isEmpty()) {
				throw new PostException("blog post not present");
			}
			return userpost.get();
			
	}

	@Override
	public Post createPost(String uuid, Post post) throws PostException, UserException {
		 CurrentUserSession loginUser = cusrepo.findByUUID(uuid);
			
			if(loginUser == null) {
				throw new UserException("User not found");
			}
			
			return postrepo.save(post);
			
		
			
	}

	@Override
	public Post updatePost(String uuid, Post postDetails) throws PostException, UserException {
		 CurrentUserSession loginUser = cusrepo.findByUUID(uuid);
			
			if(loginUser == null) {
				throw new UserException("User not found");
			}
			
			Optional<Post> opt=postrepo.findById(postDetails.getId());
			if(opt.isPresent()) {
				Post p=postrepo.save(postDetails);
				return p;
			}
			else throw new PostException("Post not found !");
	}

	@Override
	public Post deletePost(String uuid, Integer id) throws PostException, UserException {
		 CurrentUserSession loginUser = cusrepo.findByUUID(uuid);
			
			if(loginUser == null) {
				throw new UserException("User not found");
			}
			
			Optional<Post> opt=postrepo.findById(id);
			
			if(opt.isPresent()) {
				Post existingPost=opt.get();
				postrepo.delete(existingPost);
				return existingPost;
			}
			
			else
				throw new PostException("No Post Exist with the id "+id+" to Delete");
	         
	}

	

}
