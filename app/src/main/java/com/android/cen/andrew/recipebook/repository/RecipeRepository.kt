package com.android.cen.andrew.recipebook.repository

import com.android.cen.andrew.recipebook.api.RecipeService

class RecipeRepository {
    private val recipeService = RecipeService.getService()

    suspend fun getAllRecipes() = recipeService.getAllRecipes()

    suspend fun getRecipeDetails(recipeId: Int) = recipeService.getRecipeDetails(recipeId)
}