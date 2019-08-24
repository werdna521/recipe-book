package com.android.cen.andrew.recipebook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.cen.andrew.recipebook.pojo.Recipe
import com.android.cen.andrew.recipebook.pojo.RecipeDetails
import com.android.cen.andrew.recipebook.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class RecipeViewModel: ViewModel() {
    private val repository = RecipeRepository()
    val allRecipes: LiveData<List<Recipe>>
        get() {
            return liveData(Dispatchers.IO) {
                try {
                    val recipes = repository.getAllRecipes()
                    emit(recipes)
                } catch (e: Exception) {}
            }
        }

    fun getRecipeDetails(recipeId: Int): LiveData<RecipeDetails> {
        return liveData(Dispatchers.IO) {
            try {
                val recipeDetail = repository.getRecipeDetails(recipeId)
                emit(recipeDetail)
            } catch (e: Exception) {}
        }
    }
}