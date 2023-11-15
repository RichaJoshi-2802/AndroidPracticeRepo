package com.example.whatsappclone

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class SignUp : Fragment() {
    private lateinit var enterEmail      : TextInputEditText
    private lateinit var enterPassword   : TextInputEditText
    private lateinit var confirmPassword : TextInputEditText
    private lateinit var signupBtn       : Button
    private lateinit var progressBar     : ProgressBar
    private lateinit var fauth           : FirebaseAuth
    private lateinit var fstore          : FirebaseFirestore
    private lateinit var db              : DocumentReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sign_up, container, false)
        enterEmail      = view.findViewById(R.id.etSignup_email)
        enterPassword   = view.findViewById(R.id.etSignup_password)
        confirmPassword = view.findViewById(R.id.etSignup_confirm_password)
        signupBtn       = view.findViewById(R.id.btn_signup)
        progressBar     = view.findViewById(R.id.signupProgressBar)
        fauth           = FirebaseAuth.getInstance()
        fstore          = FirebaseFirestore.getInstance()

        signupBtn.setOnClickListener{
            val email = enterEmail.text.toString()
            val password = enterPassword.text.toString()
            val confirmPass = confirmPassword.text.toString()
            if(TextUtils.isEmpty(email)){
                enterEmail.error = "Email is required"
            }else if(TextUtils.isEmpty(password)){
                enterPassword.error="Password is required"
            }else if(password.length<6){
                enterPassword.error="Password must be greater than 6 characters"
            }else if(password!=confirmPass){
                confirmPassword.error = "Enter the same password as above"
            }else{
                progressBar.visibility= View.VISIBLE
                createAccount(email, password)
            }
        }

        return view
    }

    private fun createAccount(em:String, pass:String){
        fauth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener { task->
            if(task.isSuccessful){
                val userInfo = fauth.currentUser?.uid
                db = fstore.collection("users").document(userInfo.toString())
                val obj = mutableMapOf<String, String>()
                obj["userEmail"] = em
                obj["userPassword"] = pass
                obj["userName"]=""
                obj["userStatus"]=""
                db.set(obj).addOnCompleteListener {
                    Log.d("onSuccess","User Created Successfully")
                    progressBar.visibility= View.GONE
                }
            }
        }
    }
}