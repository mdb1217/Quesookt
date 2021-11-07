package org.quesong.core.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

object BindingAdapter {
    @JvmStatic
    @androidx.databinding.BindingAdapter("remoteRoundedImg")
    fun setRemoteRoundedImg(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).transform(
            CenterCrop(),
            RoundedCorners(IMAGE_RADIUS)
        ).into(imageView)
    }

    const val IMAGE_RADIUS = 20
}