package com.morioucho.lifedex.controller;

import com.morioucho.lifedex.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrieController {

    @Autowired
    private PostService postService;

    @GetMapping("/search")
    public List<String> search(@RequestParam String prefix){
        return postService.searchTitleWithPrefix(prefix);
    }
}
