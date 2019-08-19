package com.android.cen.andrew.recipebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.cen.andrew.recipebook.databinding.ActivityMainBinding
import com.android.cen.andrew.recipebook.viewmodel.RecipeViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val recipeViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(RecipeViewModel::class.java)

        recipeViewModel.allRecipes.observe(this, Observer { recipeList ->
            binding.apply {
                string = recipeList.toString()
                executePendingBindings()
            }
        })
    }
}
