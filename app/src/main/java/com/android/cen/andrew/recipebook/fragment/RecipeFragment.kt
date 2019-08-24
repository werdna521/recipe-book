package com.android.cen.andrew.recipebook.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.android.cen.andrew.recipebook.R
import com.android.cen.andrew.recipebook.databinding.FragmentRecipeBinding
import com.android.cen.andrew.recipebook.viewmodel.RecipeViewModel

class RecipeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRecipeBinding>(inflater, R.layout.fragment_recipe, container, false)
        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application).create(RecipeViewModel::class.java)
        val args = RecipeFragmentArgs.fromBundle(arguments!!)

        viewModel.getRecipeDetails(args.recipeId).observe(this, Observer { details ->
            binding.apply {
                recipeDetails = details
                executePendingBindings()
            }
        })

        return binding.root
    }
}