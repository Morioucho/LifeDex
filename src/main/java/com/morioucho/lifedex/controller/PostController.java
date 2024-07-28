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

    /**
     * Retrieves all the posts and returns them in a model.
     *
     * @param model the model to add attributes and such to
     * @return a name to display posts
     */
    @GetMapping
    public String getAllPosts(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "posts";
    }

    /**
     * Retrieves a post via ID and adds it to the model.
     *
     * @param id the ID of the post to retrieve
     * @param model the model to add attributes and such to
     * @return the view name for displaying posts
     */
    @GetMapping("/{id}")
    public String getPostByID(@PathVariable Long id, Model model){
        Post post = postService.getPostByID(id);
        model.addAttribute("post", post);

        return "post";
    }

    /**
     * Displays the form for making a new post.
     *
     * @param model the model to add attributes to
     * @return the view name for the create post form
     */
    @GetMapping("/new")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());

        return "create_post";
    }

    /**
     * Creates a new post.
     *
     * @param post the post to create
     * @return a redirect to the list of posts
     */
    @PostMapping
    public String createPost(@ModelAttribute Post post){
        postService.createPost(post);

        return "redirect:/posts";
    }

    /**
     * Deletes a post using its ID
     *
     * @param id the ID of the post to delete.
     * @return a redirect to the list of posts
     */
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id){
        // TODO: Secure this endpoint so that random posts won't be removed.
        postService.deletePost(id);

        return "redirect:/posts";
    }
}
