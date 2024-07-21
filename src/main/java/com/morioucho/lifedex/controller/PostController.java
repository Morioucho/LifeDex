package com.morioucho.lifedex.controller;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public String getAllPosts(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "posts";
    }

    @GetMapping("/{id}")
    public String getPostByID(@PathVariable Long id, Model model){
        Post post = postService.getPostByID(id);
        model.addAttribute("post", post);

        return "post";
    }

    @GetMapping("/new")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());

        return "create_post";
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post){
        postService.createPost(post);

        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePost(id);

        return "redirect:/posts";
    }
}
