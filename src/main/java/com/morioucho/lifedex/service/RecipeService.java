package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Recipe;
import com.morioucho.lifedex.repository.RecipeRepository;
import com.morioucho.lifedex.trie.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private TrieService trieService;

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe findByID(Long id){
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe createRecipe(Recipe recipe){
        recipe.setCreationDate(LocalDateTime.now());
        trieService.insertRecipe(recipe);

        return recipeRepository.save(recipe);
    }

    public List<String> searchTitleWithPrefix(String prefix){
        return trieService.searchForRecipeByPrefix(prefix);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }
}
