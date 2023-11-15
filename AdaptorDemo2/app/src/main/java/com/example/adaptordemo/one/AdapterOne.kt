
package com.example.adaptordemo.one

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.adaptordemo.R

class AdapterOne(private val context:Context, private val data:IntArray): BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =  convertView ?: LayoutInflater.from(context).inflate(R.layout.ui_view_one, parent, false)
        val imgView = view.findViewById<ImageView>(R.id.imgView)
        imgView.setImageResource(data[position])
        return view
    }
}