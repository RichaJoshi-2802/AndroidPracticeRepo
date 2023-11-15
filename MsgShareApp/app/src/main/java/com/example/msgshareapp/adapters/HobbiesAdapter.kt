package com.example.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.R
import com.example.msgshareapp.models.Hobby
import com.example.msgshareapp.showToast

class HobbiesAdapter(val context : Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val view=LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent,false))
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
 
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var currentHobby: Hobby? = null
        private var currPos: Int = 0
        init {
            itemView.setOnClickListener{
                context.showToast(currentHobby!!.title + " clicked !")
            }
            itemView.findViewById<ImageView>(R.id.imgShare).setOnClickListener {
                currentHobby?.let {
                    val message:String = "My hobby is "+currentHobby!!.title
                    val intent = Intent() //implicit intent: unknown target activity
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent,"Select from Option-"))

                }

            }
        }
        fun setData(hobby: Hobby?, pos:Int){
            hobby?.let {
                itemView.findViewById<TextView>(R.id.txvTitle).text = hobby.title
                itemView.findViewById<TextView>(R.id.txvDesc).text = hobby.desc
            }

            this.currentHobby = hobby
            this.currPos = pos
        }
    }
}