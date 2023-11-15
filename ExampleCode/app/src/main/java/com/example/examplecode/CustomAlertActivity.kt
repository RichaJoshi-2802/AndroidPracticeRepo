package com.example.examplecode

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class CustomAlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_alert)
    }

    fun openCustomDialog(view: View) {
        val dialog = Dialog(this).also {
            it.setContentView(R.layout.custom_alert_layout)
            it.show()
        }
        dialog.findViewById<Button>(R.id.btn_custom_alert).setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Custom dialog Opened", Toast.LENGTH_SHORT).show()
        }
    }
}