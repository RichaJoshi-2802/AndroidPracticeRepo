package com.example.examplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
    }

    fun openAlertDialog(view: View) {
       AlertDialog.Builder(this).also {
           it.setIcon(R.drawable.alertdemo)
           it.setTitle("Close Window")
           it.setMessage("Do you want to close the window")
           it.setCancelable(false)
           it.setPositiveButton("Yes") { _, which ->
                Toast.makeText(this, "You Clicked $which", Toast.LENGTH_SHORT).show()
                 }
           it.setNegativeButton("No"){ _, which->
               Toast.makeText(this,"You clicked $which", Toast.LENGTH_SHORT).show()
           }
           it.setNeutralButton("Cancel"){ _, which->
               Toast.makeText(this, "You clicked $which", Toast.LENGTH_SHORT).show()
           }
       }.show()
    }
}