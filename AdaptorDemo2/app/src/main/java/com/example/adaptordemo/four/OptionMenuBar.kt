package com.example.adaptordemo.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.adaptordemo.R

class OptionMenuBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.option_menu_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option1-> Toast.makeText(this, "Option 1 clicked", Toast.LENGTH_SHORT).show()
            R.id.option2 -> Toast.makeText(this, "Option 2 clicked", Toast.LENGTH_SHORT).show()
            R.id.option3-> Toast.makeText(this, "Option 3 clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}