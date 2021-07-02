package com.example.sdnapp.ui.base

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


}