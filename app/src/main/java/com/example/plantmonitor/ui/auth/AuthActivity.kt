package com.example.plantmonitor.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.ActivityAuthBinding
import com.example.plantmonitor.utils.startDashboardActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AuthActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance<AuthViewModelFactory>()

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityAuthBinding>(this, R.layout.activity_auth)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.vm = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String) {
        TODO("Not yet implemented")
    }
}