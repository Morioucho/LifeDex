package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.model.Recipe;
import com.morioucho.lifedex.trie.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrieService {
    private Trie recipeTrie;
    private Trie postTrie;

    private Trie trie;

    @PostConstruct
    public void init(){
        this.trie = new Trie();
    }

    @Deprecated
    public void insertTitle(String title){
        trie.insert(title);
    }

    @Deprecated
    public List<String> searchByPrefix(String prefix){
        return trie.searchByPrefix(prefix);
    }

    public void addAllPosts(List<Post> posts){
        for(Post p : posts){
            insertPost(p);
        }
    }

    public void addAllRecipes(List<Recipe> recipes){
        for(Recipe r : recipes){
            insertRecipe(r);
        }
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
