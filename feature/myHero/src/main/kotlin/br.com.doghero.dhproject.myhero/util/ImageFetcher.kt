package br.com.doghero.dhproject.myhero.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageFetcher {

    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}
