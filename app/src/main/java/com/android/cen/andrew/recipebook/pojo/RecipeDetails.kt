package com.android.cen.andrew.recipebook.pojo

import com.squareup.moshi.Json

data class RecipeDetails(
    @field:Json(name = "recipe_name") val recipeName: String,
    @field:Json(name = "recipe_ingredients") val recipeIngredients: String,
    @field:Json(name = "recipe_procedures") val recipeProcedures: String
)