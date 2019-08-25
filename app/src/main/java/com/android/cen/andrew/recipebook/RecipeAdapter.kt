package com.android.cen.andrew.recipebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.cen.andrew.recipebook.databinding.RecipeListItemBinding
import com.android.cen.andrew.recipebook.fragment.RecipeListFragmentDirections
import com.android.cen.andrew.recipebook.pojo.Recipe

class RecipeAdapter(private var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    inner class RecipeHolder(private val binding: RecipeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.apply {
                card.setOnClickListener {
                    binding.root.findNavController().navigate(RecipeListFragmentDirections.actionRecipeListFragmentToRecipeFragment(recipe.recipeId))
                }
                setRecipe(recipe)
                pic = getRecipeTypeDrawableRes(recipe.recipeType)
                executePendingBindings()
            }
        }

        @DrawableRes
        @ColorRes
        private fun getRecipeTypeDrawableRes(typeId: Int): Int {
            return when (typeId) {
                0 -> R.drawable.ic_bread
                1 -> R.drawable.ic_pastry
                2 -> R.drawable.ic_cake
                3 -> R.drawable.ic_donut
                4 -> R.drawable.ic_fries
                5 -> R.drawable.ic_medicine
                6 -> R.drawable.ic_roll_cake
                7 -> R.drawable.ic_sauce
                8 -> R.drawable.ic_soup
                9 -> R.drawable.ic_traditional_cake
                10 -> R.drawable.ic_dimsum
                11 -> R.drawable.ic_pancake
                else -> R.color.colorPrimaryDark
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