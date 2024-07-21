package com.morioucho.lifedex.controller;

import com.morioucho.lifedex.model.Recipe;
import com.morioucho.lifedex.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeByID(@PathVariable Long id){
        return recipeService.getRecipeByID(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return recipeService.createRecipe(recipe);
    }

    // TODO: Delete Mapping
}
