package com.example.serviceactivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings

class MyReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) =
        MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI).apply {
            isLooping = true
        }.start()
}