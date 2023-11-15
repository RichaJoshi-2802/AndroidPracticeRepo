package com.example.adaptordemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.adaptordemo.R

class Register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        view.findViewById<TextView>(R.id.loginButton).setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.frameLayoutTwo, Login()).commit()

        }        // Inflate the layout for this fragment
        return view
    }


}