package com.example.fragmentdemo.demoTwo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.fragmentdemo.R
import com.example.fragmentdemo.demoTwo.ChatAdapter
import com.example.fragmentdemo.demoTwo.Person


class Chats : Fragment() {

    private lateinit var lvChats: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        lvChats = view.findViewById(R.id.lvChats)
        // Inflate the layout for this fragment
        activity?.let { ChatAdapter(it, Person.listPerson) }.also { lvChats.adapter = it }
        return view
    }

}