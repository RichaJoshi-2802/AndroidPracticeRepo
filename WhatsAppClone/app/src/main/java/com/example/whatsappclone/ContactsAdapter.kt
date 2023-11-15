package com.example.whatsappclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ContactsAdapter(val context: Context, private val contactList: ArrayList<User>):
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    class ContactsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nam : TextView = view.findViewById(R.id.txtName)
        val email: TextView = view.findViewById(R.id.txtEmail)
        val status: TextView = view.findViewById(R.id.txtStatus)
        val image: CircleImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val contactView = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_contacts,parent,false)
        return ContactsViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val list = contactList[position]
        holder.nam.text = list.profileName
        holder.email.text = list.profileEmail
        holder.status.text = list.profileStatus
        Picasso.get().load(list.profilePicture).error(R.drawable.profile).into(holder.image)
    }
    class newClass{

    }
}