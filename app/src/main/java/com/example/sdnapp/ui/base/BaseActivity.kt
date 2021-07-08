package com.example.sdnapp.ui.base

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sdnapp.util.ProgressDialog

open class BaseActivity : AppCompatActivity() {
    var mProgressDialog: ProgressDialog =  ProgressDialog()

    fun showLoading(){
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog()
            mProgressDialog.show(supportFragmentManager,"")
        }else{
            mProgressDialog.show(supportFragmentManager,"")
        }
    }
    fun dismissLoading(){
        if (mProgressDialog != null && mProgressDialog.isVisible)
            mProgressDialog.dismiss()
    }

    fun showToast(context: Context,message:String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}