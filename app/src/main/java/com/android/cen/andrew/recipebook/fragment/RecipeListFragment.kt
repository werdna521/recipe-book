package com.android.cen.andrew.recipebook.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.android.cen.andrew.recipebook.R
import com.android.cen.andrew.recipebook.RecipeAdapter
import com.android.cen.andrew.recipebook.databinding.FragmentRecipeListBinding
import com.android.cen.andrew.recipebook.viewmodel.RecipeViewModel

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRecipeListBinding>(inflater, R.layout.fragment_recipe_list, container, false)
        val recipeViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application).create(RecipeViewModel::class.java)

        recipeViewModel.allRecipes.observe(viewLifecycleOwner, Observer { recipes ->
            binding.apply {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RecipeAdapter(recipes)
                    Log.d("okokok", recipes.toString())
                }
            }
        })

        return binding.root
    }
}
