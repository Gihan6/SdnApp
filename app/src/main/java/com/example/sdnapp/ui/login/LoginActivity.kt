package com.example.sdnapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.db.Repo
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.vechicles.VechiclesActivity
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity() {

    companion object {
        lateinit var loggedInUser: Repo
    }

    private val viewModel by inject<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListenerForViewModel()
        login()
        viewModel.getLoggedInUserFromLocal()


    }

    private fun login() {
        btn_login.setOnClickListener(View.OnClickListener {
            if (!et_userName.text.toString().isNullOrEmpty()
                && !et_password.text.toString().isNullOrEmpty()
            ) {
                viewModel.getSessionTokenFromWebServices(
                    SessionTokenRequest(
                        et_userName.text.toString(),
                        et_password.text.toString(),
                        true
                    )
                )
            } else {
                Toast.makeText(this, "Compete data", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun initListenerForViewModel() {
        viewModel.getSessionToken().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        goToMain()
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }
        })
        viewModel.getLoggedInUser().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        if (it.data != null) {
                            loggedInUser = it.data
                            goToMain()
                        }

                    }
                    Status.ERROR -> {
                        dismissLoading()
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                    }
                    Status.LOADING -> {
                        showLoading()

                    }
                }
            }
        })

    }

    private fun goToMain() {
        var intent = Intent(this, VechiclesActivity::class.java)
        startActivity(intent)

    }
}