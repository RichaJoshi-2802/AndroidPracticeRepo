package com.example.whatsappclone

import android.graphics.Bitmap
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.io.ByteArrayOutputStream


class Profile : Fragment() {
    private lateinit var profileName: TextView
    private lateinit var profileMail: TextView
    private lateinit var profileStatus: TextView
    private lateinit var profilePicture: CircleImageView
    private lateinit var profilePicAdd: ImageView
    private lateinit var profileNameEdit: TextInputLayout
    private lateinit var profileMailEdit: TextInputLayout
    private lateinit var profileStatusEdit: TextInputLayout
    private lateinit var editName: TextInputEditText
    private lateinit var editMail: TextInputEditText
    private lateinit var editStatus: TextInputEditText
    private lateinit var profileUpdate: Button
    private lateinit var profileSave: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var fauth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore
    private lateinit var db: DocumentReference
    private lateinit var userid:String
    private lateinit var image: ByteArray
    private lateinit var storeRef: StorageReference
    private val register = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
        uploadImage(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fauth = FirebaseAuth.getInstance()
        fstore = FirebaseFirestore.getInstance()
        userid = fauth.currentUser!!.uid
        storeRef = FirebaseStorage.getInstance().reference.child("$userid/profilePhoto")
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        profileName = view.findViewById(R.id.txtProfileName)
        profileMail = view.findViewById(R.id.txtProfileMail)
        profileStatus = view.findViewById(R.id.txtProfileStatus)
        profilePicture= view.findViewById(R.id.profile_image)
        profilePicAdd = view.findViewById(R.id.add_profile_image)
        profileNameEdit = view.findViewById(R.id.profileName)
        profileMailEdit = view.findViewById(R.id.profileMail)
        profileStatusEdit = view.findViewById(R.id.profileStatus)
        editName = view.findViewById(R.id.etName)
        editMail= view.findViewById(R.id.etMail)
        editStatus = view.findViewById(R.id.etStatus)
        profileUpdate = view.findViewById(R.id.btnProfileUpdate)
        profileSave = view.findViewById(R.id.btnProfileSave)
        progressBar = view.findViewById(R.id.profile_progress)
        db = fstore.collection("users").document(userid)
        db.addSnapshotListener{value, error->
            if(error!=null){
                Log.d("Error","Unable to fetch data")
            }
            else{
                profileName.text = value?.getString("userName")
                profileMail.text = value?.getString("userEmail")
                profileStatus.text = value?.getString("userStatus")
                Picasso.get().load(value?.getString("userProfilePhoto")).error(R.drawable.profile).into(profilePicture)
            }
        }

        profileUpdate.setOnClickListener {
            profileName.visibility = View.GONE
            profileMail.visibility = View.GONE
            profileStatus.visibility = View.GONE
            profileNameEdit.visibility = View.VISIBLE
            profileMailEdit.visibility = View.VISIBLE
            profileStatusEdit.visibility = View.VISIBLE
            profileUpdate.visibility =View.GONE
            profileSave.visibility = View.VISIBLE
            editName.text = Editable.Factory.getInstance().newEditable(profileName.text.toString())
            editMail.text = Editable.Factory.getInstance().newEditable(profileMail.text.toString())
            editStatus.text = Editable.Factory.getInstance().newEditable(profileStatus.text.toString())
        }

        profileSave.setOnClickListener {
            profileName.visibility = View.VISIBLE
            profileMail.visibility = View.VISIBLE
            profileStatus.visibility = View.VISIBLE
            profileNameEdit.visibility = View.GONE
            profileMailEdit.visibility = View.GONE
            profileStatusEdit.visibility = View.GONE
            profileUpdate.visibility =View.VISIBLE
            profileSave.visibility = View.GONE
            val obj = mutableMapOf<String, String>()
            obj["userName"] = editName.text.toString()
            obj["userStatus"] = editStatus.text.toString()
            obj["userEmail"] = editMail.text.toString()
            db.set(obj).addOnSuccessListener {
                Log.d("Success","Data Successfully Updated")
            }
        }

        profilePicAdd.setOnClickListener {
            capturePhoto()
        }

        return view
    }

    private fun capturePhoto() {
        register.launch(null)
    }

    private fun uploadImage(it: Bitmap?) {
        val baos = ByteArrayOutputStream()
        it?.compress(Bitmap.CompressFormat.JPEG, 50, baos)
        image = baos.toByteArray()
        storeRef.putBytes(image).addOnSuccessListener {
            storeRef.downloadUrl.addOnSuccessListener {
                val obj = mutableMapOf<String, String>()
                obj["userProfilePhoto"] = it.toString()
                db.update(obj as Map<String, Any>).addOnSuccessListener {
                    Log.d("onSuccess", "Profile Picture Updated")
                }
            }
        }
    }
}