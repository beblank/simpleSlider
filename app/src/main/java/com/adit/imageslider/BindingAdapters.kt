package com.adit.imageslider

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

object BindingAdapters{
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(view:ImageView, url:String) {
        Picasso.get()
                .load(url)
                .into(view)
    }

}
