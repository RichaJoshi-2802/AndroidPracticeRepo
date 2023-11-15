package com.example.examplecode

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast.*

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        makeText(this,"Service started", LENGTH_SHORT).show()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        makeText(this, "Service Destroyed", LENGTH_LONG).show()
    }

    override fun onCreate() {
        super.onCreate()
        makeText(this,"OnCreate() Service called", LENGTH_SHORT).show()
    }

}