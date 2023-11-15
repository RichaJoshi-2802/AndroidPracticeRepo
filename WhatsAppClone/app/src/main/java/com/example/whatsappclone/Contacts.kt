package com.example.whatsappclone

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class Contacts : Fragment() {
    private lateinit var cRecycleView: RecyclerView
    private lateinit var cLayoutManager: RecyclerView.LayoutManager
    private lateinit var cAdapter: ContactsAdapter
    private lateinit var fstore: FirebaseFirestore
    private lateinit var fauth: FirebaseAuth
    private val contactInfo = arrayListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        cRecycleView = view.findViewById(R.id.contactsRecycleView)
        cLayoutManager = LinearLayoutManager(context as Activity)
        fstore = FirebaseFirestore.getInstance()
        fauth = FirebaseAuth.getInstance()
        fstore.collection("users").get().addOnSuccessListener {
            if(!it.isEmpty){
                val listContact = it.documents
                for(i in listContact){
                    if(i.id==fauth.currentUser?.uid){
                        Log.d("onFound","This is user Account")

                    }else{
                        val contact = User(i.get("userName").toString(),
                            i.get("userEmail").toString(),
                            i.get("userStatus").toString(),
                            i.get("userProfilePhoto").toString())
                        contactInfo.add(contact)
                        cAdapter = ContactsAdapter(context as Activity, contactInfo)
                        cRecycleView.adapter = cAdapter
                        cRecycleView.layoutManager = cLayoutManager
                        cRecycleView.addItemDecoration(DividerItemDecoration(cRecycleView.context,(cLayoutManager as LinearLayoutManager).orientation))

                    }
                }
            }
        }
         return view
    }

}