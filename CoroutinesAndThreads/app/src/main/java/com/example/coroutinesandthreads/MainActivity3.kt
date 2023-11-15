package com.example.coroutinesandthreads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG= "MyTag"

@OptIn(DelicateCoroutinesApi::class)
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        GlobalScope.launch(Dispatchers.Main){
            execute()
        }
    }

    private suspend fun execute(){
        val parentJob = GlobalScope.launch(Dispatchers.Main){
            Log.d(TAG, "Parent Started")

            val childJob = launch {
                Log.d(TAG, "Child job started")
                delay(5000)
                Log.d(TAG, "Child Ended")
            }
            delay(3000)
            childJob.cancel()
            Log.d(TAG, "Parent Ended")
        }
        parentJob.join()
        Log.d(TAG, "Parent Completed")
    }
}
