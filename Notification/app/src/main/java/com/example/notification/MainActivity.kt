package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private val channelId = "message_notification"
    private val channelName = "New Channel"
    private val notificationId = 1
   // val executorService = Executors.newFixedThreadPool(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder = Notification.Builder(this).apply {
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.info))
            setSmallIcon(R.drawable.info)
            setContentTitle("New Message")
            setContentText("New Message from xyz")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                setChannelId(channelId)
                nm.createNotificationChannel(
                    NotificationChannel(
                        channelId,
                        channelName,
                        NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }
        }
        val notification = builder.build()
        nm.notify(notificationId, notification)

    }

}