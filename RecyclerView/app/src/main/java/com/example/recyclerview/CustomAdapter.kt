package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val context: Context, private val dataSet: List<Student>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView
        val textView2: TextView

        var currName:String? = null

        init {
            view.setOnClickListener {
                Toast.makeText(context, "$currName clicked", Toast.LENGTH_SHORT).show()
            }
            textView1 = view.findViewById(R.id.textView1)
            textView2 = view.findViewById(R.id.textView2)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.text_row_detail, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        dataSet[position].name.also {
            viewHolder.textView1.text = it
            viewHolder.currName = it
        }
        viewHolder.textView2.text = dataSet[position].phno

    }

    override fun getItemCount() = dataSet.size

}
