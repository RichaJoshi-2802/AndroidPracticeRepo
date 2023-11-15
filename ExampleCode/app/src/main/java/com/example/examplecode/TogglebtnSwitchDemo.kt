package com.example.examplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton

class TogglebtnSwitchDemo : AppCompatActivity() {
    private lateinit var wifiToggleBtn:ToggleButton
    private lateinit var wifiSwitchBtn:Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_togglebtn_switch_demo)
        wifiToggleBtn = findViewById(R.id.wifiToggleBtn)
        wifiSwitchBtn = findViewById(R.id.wifiSwitchBtn)

    }

    fun getValueFromToggleBtn(view: View) {
        if(wifiToggleBtn.isChecked){
            Toast.makeText(this,"Wifi Off",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"Wifi On",Toast.LENGTH_SHORT).show()
        }
    }

    fun getValueFromSwitch(view: View) {
        if(wifiSwitchBtn.isChecked){
            Toast.makeText(this,"Wifi On",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"Wifi Off",Toast.LENGTH_SHORT).show()
        }
    }
}