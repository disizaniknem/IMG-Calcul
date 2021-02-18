package com.disizaniknem.imgcalcul.ui

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.disizaniknem.imgcalcul.R

fun View.zoom(context: Context, animTime: Long, startOffset: Long, anim: Int) {
    val slideUp = AnimationUtils.loadAnimation(context, anim).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffset
    }
    startAnimation(slideUp)
}

fun View.zoomIn(context: Context) {
    this.zoom(context, 500, 0, R.anim.zoom_in)
}

fun View.zoomOut(context: Context) {
    this.zoom(context, 200, 0, R.anim.zoom_out)
}