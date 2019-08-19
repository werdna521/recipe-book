package com.android.cen.andrew.recipebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.cen.andrew.recipebook.databinding.RecipeListItemBinding
import com.android.cen.andrew.recipebook.pojo.Recipe

class RecipeAdapter(private var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    inner class RecipeHolder(private val binding: RecipeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.apply {
                setRecipe(recipe)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RecipeListItemBinding>(
                        inflater,
                        R.layout.recipe_list_item,
                        parent,
                        false
                    )
        return RecipeHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(recipes[position])
    }

    fun updateRecipes(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }
}