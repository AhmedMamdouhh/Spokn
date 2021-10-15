package com.spokn.manager.utilities

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.spokn.R
import com.bumptech.glide.load.model.LazyHeaders

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition


@BindingAdapter("imageUrl")
fun ImageView.bindImage( imgUrl: String?) {


    val theImage = GlideUrl(
        imgUrl, LazyHeaders.Builder()
            .addHeader("User-Agent", "5")
            .build()
    )

    theImage.let {
        Glide.with(this.context)
            .load(theImage)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_broken_image)

            )
            .into(object : CustomViewTarget<ImageView, Drawable>(this) {
                override fun onLoadFailed(errorDrawable: Drawable?) {}
                override fun onResourceCleared(placeholder: Drawable?) {}
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    this@bindImage.setImageDrawable(resource)
                }
            })    }
}

