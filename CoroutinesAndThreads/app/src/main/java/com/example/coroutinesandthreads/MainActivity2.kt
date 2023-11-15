package com.example.coroutinesandthreads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    private suspend fun printFollowers() {

        /*var fbFollowers = 0
        var instaFollowers = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getfbfollowers()
        }
        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instaFollowers = getinstafollowers()
        }
        job.join()
        job2.join()*/

        /*val fb = CoroutineScope(Dispatchers.IO).async {
            getfbfollowers()
        }

        val insta = CoroutineScope(Dispatchers.IO).async {
            getinstafollowers()
        }

        Log.d(TAG, "FB-> ${fb.await()} Insta-> ${insta.await()}")*/

        CoroutineScope(Dispatchers.IO).launch {
            val fb = async{ getfbfollowers() }
            val insta = async{ getinstafollowers() }
            Log.d(TAG, "FB-> ${fb.await()} Insta-> ${insta.await()}")
        }
    }

    private suspend fun getfbfollowers():Int{
        delay(1000)
        return 54
    }

    private suspend fun getinstafollowers():Int{
        delay(1000)
        return 113
    }
}