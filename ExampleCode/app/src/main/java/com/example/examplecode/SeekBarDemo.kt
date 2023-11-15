package com.example.examplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class SeekBarDemo : AppCompatActivity() {
    private lateinit var seekbar: SeekBar
    private lateinit var sbView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_demo)

        seekbar = findViewById(R.id.seekbar)
        sbView = findViewById(R.id.sb_view)

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            var progress_val = 0
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progress_val = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //sbView.setText(progress_val)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                sbView.setText(progress_val)
            }

        })
    }
}