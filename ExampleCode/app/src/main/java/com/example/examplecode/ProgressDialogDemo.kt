package com.example.examplecode


import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ProgressDialogDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_dialog_demo)
    }

    fun openProgressBar(view: View) {
        val prog = ProgressDialog(this).also {
            it.setTitle("Progress dialog title")
            it.setMessage("Progress")
            it.setCancelable(false)
            it.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            it.show()
        }


        Thread{
            try {
                Thread.sleep(5000)
                prog.dismiss()
            }
            catch(e:Exception){
                e.printStackTrace()
            }
        }.start()
    }
}