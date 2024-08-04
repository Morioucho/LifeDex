package com.morioucho.lifedex.controller;

import com.morioucho.lifedex.service.TrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api")
@Controller
public class TrieController {
    @Autowired
    private TrieService trieService;

    @GetMapping("/recipes/search")
    public ResponseEntity<List<String>> searchRecipes(@RequestParam String query){
        List<String> foundRecipes = trieService.searchForRecipeByPrefix(query);
        if(foundRecipes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundRecipes, HttpStatus.OK);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<List<String>> searchPosts(@RequestParam String query){
        List<String> foundPosts = trieService.searchForPostsByPrefix(query);
        if(foundPosts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundPosts, HttpStatus.OK);
    }
}
