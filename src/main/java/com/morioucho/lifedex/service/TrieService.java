package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.model.Recipe;

import com.morioucho.lifedex.trie.Trie;
import com.morioucho.lifedex.trie.TrieBuilder;
import com.morioucho.lifedex.trie.TrieType;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrieService {
    private final TrieBuilder trieBuilder;

    private Trie recipeTrie;
    private Trie postTrie;

    @Autowired
    public TrieService(TrieBuilder trieBuilder){
        this.trieBuilder = trieBuilder;
    }

    @PostConstruct
    public void init(){
        this.recipeTrie = trieBuilder.build(TrieType.RECIPE);
        this.postTrie = trieBuilder.build(TrieType.POST);
    }

    public void insertPost(Post post){
        postTrie.insert(post.getTitle());
    }

    public void insertRecipe(Recipe recipe){
        recipeTrie.insert(recipe.getTitle());
    }

    public List<String> searchForPostsByPrefix(String prefix){
        return postTrie.searchByPrefix(prefix);
    }

    public List<String> searchForRecipeByPrefix(String prefix){
        return recipeTrie.searchByPrefix(prefix);
    }
}
