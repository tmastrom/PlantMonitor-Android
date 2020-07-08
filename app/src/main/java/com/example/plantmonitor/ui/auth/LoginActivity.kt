package com.example.plantmonitor.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.ActivityLoginBinding
import com.example.plantmonitor.utils.startDashboardActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance<AuthViewModelFactory>()

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.vm = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        //progressbar.visibility = View.VISIBLE
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
        //progressbar.visibility = View.GONE
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        startDashboardActivity()
    }

    override fun onFailure(message: String) {
        //progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            startDashboardActivity()
        }
    }
}