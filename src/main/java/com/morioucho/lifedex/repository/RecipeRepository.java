package com.morioucho.lifedex.repository;

import com.morioucho.lifedex.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
