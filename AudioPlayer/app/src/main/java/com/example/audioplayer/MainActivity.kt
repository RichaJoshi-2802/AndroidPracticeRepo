package com.example.audioplayer

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var play: Button
    private lateinit var pause: Button
    private lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp = MediaPlayer()
        //val path = "android.resource://$packageName/raw/sample_one"
        val onlinePath = "https://file-examples.com/storage/feaade38c1651bd01984236/2017/11/file_example_MP3_700KB.mp3"
        mp.setDataSource(this, Uri.parse(onlinePath))
        mp.isLooping = true
        mp.prepare()

        play = findViewById<Button?>(R.id.play).also {
            it.setOnClickListener {
                mp.start()
            }
        }
        pause = findViewById<Button?>(R.id.pause).also {
            it.setOnClickListener {
                mp.pause()
            }
        }
        stop = findViewById<Button?>(R.id.stop).also {
            it.setOnClickListener {
                mp.pause()
                mp.seekTo(0)
            }
        }

    }
}