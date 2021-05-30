package com.example.marvelclient.utils

import android.view.View.GONE
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.marvelclient.R
import com.example.marvelclient.model.Thumbnail
import com.example.marvelclient.model.comic.Item
import com.example.marvelclient.model.comic.Price

@BindingAdapter("isGone")
fun isGone(progressBar: ProgressBar,bool: Boolean){
    if(!bool) progressBar.visibility = GONE
}

@BindingAdapter("src")
fun setImage(imgView: ImageView,thumbnail: Thumbnail?){
    thumbnail?.let{
        val url = thumbnail.path + "." + thumbnail.extension
        Glide.with(imgView)
            .load(url)
            .transition(withCrossFade())
            .placeholder(R.drawable.ic_marvel)
            .into(imgView)
    }
}

@BindingAdapter("listText")
fun makeText(txtView: TextView,prices: List<Price>?){
    prices?.let{
        var result = ""
        for(price in prices)
            result += "${price.type.capitalize()}: ${price.price}$\n"
        txtView.text = result
    }
}

@BindingAdapter("featuring")
fun makeFeatureText(textView: TextView,character: List<Item>?){
    character?.let {
        var result = ""
        for (char in character) {
            result += if(char == character[character.size - 1])
                char.name.capitalize()
            else
                "${char.name.capitalize()}, "
        }
        textView.text = result
    }
}