package com.example.serviceactivity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/* ELAPSED_REALTIME - fires the pending intent after the specified length of time since device boot.
                      if the device is asleep, it fires when the device is next awake.
* ELAPSED_REALTIME_WAKEUP - fires the pending intent after the specified length of time since device boot.
                            it wakes up the device if it is asleep.
* RTC - fires the pending intent at a specifies time. if the device is asleep,
        it will not be delivered until the next time the device wakes up.
* RTC_WAKEUP - waking up the device  */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        findViewById<Button>(R.id.btnTime).setOnClickListener {
            val time = Integer.parseInt(findViewById<EditText>(R.id.edtTime).text.toString())
            val triggerTime = System.currentTimeMillis()+(time*1000)
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent =  PendingIntent.getBroadcast(this, 10,intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime,pendingIntent)
        }

    }
}