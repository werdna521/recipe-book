package com.android.cen.andrew.recipebook.api

import com.android.cen.andrew.recipebook.pojo.Recipe
import com.android.cen.andrew.recipebook.pojo.RecipeDetails
import com.android.cen.andrew.recipebook.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    companion object {
        fun getService(): RecipeService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(RecipeService::class.java)
        }
    }

    @GET("/recipe/api/getAllRecipes.php")
    suspend fun getAllRecipes(): List<Recipe>

    @GET("/recipe/api/getRecipeDetails.php")
    suspend fun getRecipeDetails(@Query(value = "recipe_id") recipeId: Int): RecipeDetails
}