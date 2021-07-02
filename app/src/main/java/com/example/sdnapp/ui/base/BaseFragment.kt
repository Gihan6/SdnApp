package com.example.sdnapp.ui.base

import androidx.fragment.app.Fragment
import com.example.sdnapp.util.ProgressDialog

open class BaseFragment : Fragment() {
    var mProgressDialog: ProgressDialog = ProgressDialog()

    fun showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog=ProgressDialog()
            mProgressDialog.show(requireActivity().supportFragmentManager.beginTransaction(), "")
        } else {
            mProgressDialog.show(requireActivity().supportFragmentManager.beginTransaction(), "")
        }
    }

    fun dismissLoading() {
        if (mProgressDialog != null&&mProgressDialog.isVisible)
            mProgressDialog.dismiss()
    }
}