package com.example.audioplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var videoView:VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoView = findViewById(R.id.videoView)

        //val vPath = "android.resource://$packageName/raw/sample_video"
        val onlinePath = "https://file-examples.com/storage/feaade38c1651bd01984236/2017/04/file_example_MP4_480_1_5MG.mp4"

        videoView.setVideoURI(Uri.parse(onlinePath))
        videoView.start()

        videoView.setMediaController(MediaController(this).also { it.setAnchorView(videoView) })

    }
}