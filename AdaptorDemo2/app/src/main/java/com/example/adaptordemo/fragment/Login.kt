package com.example.adaptordemo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.adaptordemo.R


class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.findViewById<TextView>(R.id.registerButton).setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.frameLayoutTwo, Register()).commit()
        }
        // Inflate the layout for this fragment
        return view
    }


}