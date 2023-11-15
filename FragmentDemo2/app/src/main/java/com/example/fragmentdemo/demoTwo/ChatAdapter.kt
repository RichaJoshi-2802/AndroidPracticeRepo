package com.example.fragmentdemo.demoTwo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.fragmentdemo.R

class ChatAdapter(context:Context,items: List<User>) : ArrayAdapter<User>(context, 0, items){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_box,parent,false)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

        return inflater.inflate(R.layout.chat_box, null).apply {
            findViewById<ImageView>(R.id.imgUser).also {
                item?.image
            }
            findViewById<TextView>(R.id.txtName).also {its->
                its.text = item?.name
            }

        }
    }

}