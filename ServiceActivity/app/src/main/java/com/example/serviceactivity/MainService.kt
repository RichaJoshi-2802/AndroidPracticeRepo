package com.example.serviceactivity

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log


class MainService : Service() {

    private lateinit var mp:MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread {
            while (true) {
                Log.e("Service", "Service is running...")
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mp.stop()
        super.onDestroy()
    }
}