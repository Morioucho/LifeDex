package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Recipe;
import com.morioucho.lifedex.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    private TrieService trieService;

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Recipe findByID(Long id){
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe createRecipe(Recipe recipe){
        recipe.setCreationDate(LocalDateTime.now());

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }
}
