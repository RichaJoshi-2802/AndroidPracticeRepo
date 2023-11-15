package com.example.examplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView

class ImageSwitcherDemo : AppCompatActivity() {
    private lateinit var imageSwitcher: ImageSwitcher
    private val image = intArrayOf(R.drawable.alertdemo, R.drawable.calendar, R.drawable.time)
    private var imgIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_switcher_demo)
        imageSwitcher = findViewById(R.id.imageSwitcher)

        imageSwitcher.setFactory{
            ImageView(this).apply {
                scaleType = ImageView.ScaleType.FIT_CENTER
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }
        }

        imageSwitcher.setImageResource(image[0])
    }

    fun onClickLeft(view: View) {
        ((if(imgIndex==0) image.size-1 else (imgIndex-1)%image.size)).also { imgIndex = it }

        imageSwitcher.setImageResource(image[imgIndex])
    }

    fun onClickRight(view: View) {
        imgIndex = (imgIndex+1)%image.size
        imageSwitcher.setImageResource(image[imgIndex])

    }
}