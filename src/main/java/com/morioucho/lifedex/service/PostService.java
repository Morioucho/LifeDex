package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post getPostByID(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post){
        post.setCreationAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
