package com.example.coroutinesandthreads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    private suspend fun task1(){
        Log.d("tag", "Starting task 1")
        yield()
        Log.d("tag", "Ending task 1")
    }

    private suspend fun task2(){
        Log.d("tag", "Starting task 2")
        delay(1000)
        Log.d("tag", "Ending task 2")
    }
}