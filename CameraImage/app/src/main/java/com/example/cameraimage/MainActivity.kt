package com.example.cameraimage

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imgCamera:ImageView
    private lateinit var btn:Button
    private lateinit var btn1:Button
    private val cameraReqCode = 10
    private val galleryReqCode = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgCamera = findViewById(R.id.imgCamera)
        btn = findViewById<Button?>(R.id.btn).also {
            it.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, cameraReqCode)
            }
        }

        btn1 = findViewById<Button?>(R.id.btn1).also {
            it.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, galleryReqCode)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK){
            when(requestCode) {
                cameraReqCode-> {
                    val myData = data?.extras?.get("data") as Bitmap
                    imgCamera.setImageBitmap(myData)
                }

                galleryReqCode-> {
                    imgCamera.setImageURI(data?.data)
                }
            }
        }

    }
}