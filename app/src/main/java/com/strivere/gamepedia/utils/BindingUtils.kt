package com.strivere.gamepedia.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.strivere.gamepedia.R

@BindingAdapter("image")
fun loadImage(view : ImageView, url : String?){
    Glide.with(view)
        .load(url)
        .into(view)
}

@BindingAdapter("imageRound")
fun loadImageRound(view : ShapeableImageView, url: String?){
    val radius = view.resources.getDimension(R.dimen.rounded)
    val imageContent: ShapeableImageView = view
    imageContent.shapeAppearanceModel = imageContent.shapeAppearanceModel
        .toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED,radius)
        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
        .build()
}
