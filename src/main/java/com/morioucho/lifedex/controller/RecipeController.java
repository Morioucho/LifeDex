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

    /**
     * Retrieves all the recipes.
     *
     * @return all the recipes
     */
    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    /**
     * Returns a recipe via its ID
     *
     * @param id the ID of the recipe
     * @return the recipe with said ID
     */
    @GetMapping("/{id}")
    public Recipe getRecipeByID(@PathVariable Long id){
        return recipeService.getRecipeByID(id);
    }

    /**
     * Creates a new recipe.
     *
     * @param recipe the recipe to create
     * @return the created recipe
     */
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return recipeService.createRecipe(recipe);
    }

    // TODO: Delete Mapping
}
