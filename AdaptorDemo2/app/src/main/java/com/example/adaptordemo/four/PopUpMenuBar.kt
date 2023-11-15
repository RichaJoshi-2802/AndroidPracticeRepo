package com.example.adaptordemo.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import com.example.adaptordemo.R

class PopUpMenuBar : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_menu_bar)
        button = findViewById(R.id.buttonOne)
        button.setOnClickListener {
            val popupMenu = PopupMenu(this, button)
            popupMenu.menuInflater.inflate(R.menu.pop_up_menus, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener{ menuItem->
                when (menuItem.itemId) {
                    R.id.menuOne -> {
                        Toast.makeText(this,"Menu 1 clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menuTwo -> {
                        Toast.makeText(this,"Menu 2 clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menuThree -> {
                        Toast.makeText(this,"Menu 3 clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }
}