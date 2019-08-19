package com.android.cen.andrew.recipebook.pojo

import com.squareup.moshi.Json

data class Recipe(
    @field:Json(name = "recipe_id") val recipeId: Int,
    @field:Json(name = "recipe_name") val recipeName: String
)