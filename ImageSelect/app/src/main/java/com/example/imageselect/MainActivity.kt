package com.example.imageselect

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var btnSelectImage:Button
    private lateinit var imgShow: ImageView
    private val SELECT_PICTURE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgShow = findViewById(R.id.imgShow)
        btnSelectImage = findViewById<Button?>(R.id.btnSelectImage).also {
            it.setOnClickListener {
                imageChooser()
            }
        }

    }

    private fun imageChooser() {
        val intent = Intent().apply {
            type = "image/*"
            action = ACTION_GET_CONTENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE)
    }

    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            if(requestCode == SELECT_PICTURE){
                val selectedImageUri = data?.data
                if(null!= selectedImageUri){
                    imgShow.setImageURI(selectedImageUri)
                    imgShow.visibility = View.VISIBLE
                }
            }
        }

    }
}