package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AlertDialog.Builder(this).create().apply {
            setTitle("Terms and Conditions")
            setIcon(R.drawable.info)
            setMessage("Have you read all the T&C")
            setCancelable(false)
            setButton(DialogInterface.BUTTON_NEUTRAL,"Yes, I have read") { _, _ ->
                Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
            }

            show()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Exit App")
            setMessage("Are you sure you want to exit the app?")
            setPositiveButton("Yes") { _, _ ->
                super.onBackPressed()
            }
            setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            show()
        }
    }
}
