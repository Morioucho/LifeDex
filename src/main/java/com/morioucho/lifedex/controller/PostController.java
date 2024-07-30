package com.morioucho.lifedex.controller;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.service.PostService;
import com.morioucho.lifedex.service.TrieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private TrieService trieService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable Long id){
        return postService.getPostByID(id);
    }

    @PostMapping("/new")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id){
        // TODO: Secure this endpoint so that random posts won't be removed.

        postService.deletePost(id);
    }
}
