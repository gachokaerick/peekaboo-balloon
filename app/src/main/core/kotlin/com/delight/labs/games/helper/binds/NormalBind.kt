package com.delight.labs.games.helper.binds

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * 页面描述：normal bind class
 *
 * Created by ditclear on 2017/10/2.
 */

@BindingAdapter(value = ["url"])
fun bindUrl(imageView: ImageView, url: String?) {

    Glide.with(imageView.context).load(url).into(imageView)
}