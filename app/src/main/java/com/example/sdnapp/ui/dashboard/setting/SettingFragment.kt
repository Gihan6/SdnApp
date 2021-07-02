package com.example.sdnapp.ui.dashboard.setting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_setting.*
import org.koin.android.ext.android.inject


class SettingFragment : BaseFragment() {
    private val viewModel by inject<SettingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logOut()
    }

    private fun logOut() {
        btn_logout.setOnClickListener(View.OnClickListener {

            viewModel.logOutFromApp()
        })
    }

    private fun initViewModel() {
        viewModel.logOut().observe(requireActivity(), Observer {
            var intent = Intent(requireContext(), LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)

        })
    }
}