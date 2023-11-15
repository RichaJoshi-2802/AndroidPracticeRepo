package com.example.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import pl.droidsonroids.gif.GifImageView

class SplashActivity : AppCompatActivity() {
    private var splashScreenTime = 3000
    private lateinit var imageGif: GifImageView
    private lateinit var topAnim: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageGif = findViewById(R.id.splashView)

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        imageGif.animation = topAnim
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, AuthenticationActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenTime.toLong())
    }
}