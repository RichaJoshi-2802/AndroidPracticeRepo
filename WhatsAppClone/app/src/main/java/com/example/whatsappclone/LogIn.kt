package com.example.whatsappclone

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class LogIn : Fragment() {
    private lateinit var enterEmail: TextInputEditText
    private lateinit var enterPassword: TextInputEditText
    private lateinit var loginBtn: Button
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)
        enterEmail = view.findViewById(R.id.etLogin_email)
        enterPassword = view.findViewById(R.id.etLogin_password)
        loginBtn = view.findViewById(R.id.btn_login)
        progress = view.findViewById(R.id.loginProgressBar)

        loginBtn.setOnClickListener {
            val email = enterEmail.text.toString()
            val password = enterPassword.text.toString()
            if(TextUtils.isEmpty(email)){
                enterEmail.error = "Email is required"
            }else if(TextUtils.isEmpty(password)){
                enterPassword.error="Password is required"
            }else{
                progress.visibility = View.VISIBLE
                signIn(email, password)
            }
        }
        return view
    }

    private fun signIn(em:String, pass:String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(em, pass).addOnCompleteListener { task->
            if(task.isSuccessful){
                Toast.makeText(context,"Login Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }

}