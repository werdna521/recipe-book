package com.android.cen.andrew.recipebook.databindingadapter

import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("imageResource")
fun ImageView.setImage(@DrawableRes @ColorRes res: Int) {
    setImageResource(res)
}

@BindingAdapter("visible")
fun ImageView.setVisible(isVisible: Int) {
    visibility = if (isVisible == 1) View.VISIBLE else View.GONE
}