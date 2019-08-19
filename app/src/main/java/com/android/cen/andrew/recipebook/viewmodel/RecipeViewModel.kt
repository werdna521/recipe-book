package com.android.cen.andrew.recipebook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.cen.andrew.recipebook.pojo.Recipe
import com.android.cen.andrew.recipebook.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers

class RecipeViewModel: ViewModel() {
    private val repository = RecipeRepository()
    val allRecipes: LiveData<List<Recipe>>
        get() {
            return liveData(Dispatchers.IO) {
                val recipes = repository.getAllRecipes()
                emit(recipes)
            }
        }
}