package com.morioucho.lifedex.trie;

import com.morioucho.lifedex.model.Recipe;
import com.morioucho.lifedex.model.Post;


import com.morioucho.lifedex.service.PostService;
import com.morioucho.lifedex.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrieBuilder {
    private final PostService postService;
    private final RecipeService recipeService;

    @Autowired
    public TrieBuilder(PostService postService, RecipeService recipeService){
        this.postService = postService;
        this.recipeService = recipeService;
    }

    public Trie build(TrieType type) {
        Trie trie = new Trie();
        switch (type) {
            case RECIPE:
                for (Recipe r : recipeService.findAll()) {
                    trie.insert(r.getTitle());
                }
                break;
            case POST:
                for (Post p : postService.findAll()) {
                    trie.insert(p.getTitle());
                }
                break;
            default:
                break;
        }
        return trie;
    }
}

