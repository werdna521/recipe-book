package com.android.cen.andrew.recipebook.pojo

import com.squareup.moshi.Json

data class Recipe(
    @field:Json(name = "recipe_id") val recipeId: Int,
    @field:Json(name = "recipe_name") val recipeName: String,
    @field:Json(name = "is_sweet") val isSweet: Int,
    @field:Json(name = "is_sour") val isSour: Int,
    @field:Json(name = "is_spicy") val isSpicy: Int,
    @field:Json(name = "is_salty") val isSalty: Int,
    @field:Json(name = "recipe_type") val recipeType: Int
)