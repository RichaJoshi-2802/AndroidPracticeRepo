package com.example.adaptordemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.adaptordemo.R

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_one, container, false)
        view.findViewById<Button>(R.id.fragButtonOne).setOnClickListener {
            Toast.makeText(context, "Fragment Button Clicked", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}