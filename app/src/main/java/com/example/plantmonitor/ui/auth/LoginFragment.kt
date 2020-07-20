package com.example.plantmonitor.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.FragmentHomeBinding
import com.example.plantmonitor.databinding.FragmentLoginBinding
import com.example.plantmonitor.utils.startDashboardActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

        binding.textViewLogin.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        return binding.root
    }

/*    override fun onStarted() {
        //progressbar.visibility = View.VISIBLE
        //Toast.makeText(this, "started", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
        //progressbar.visibility = View.GONE
        //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
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
    }*/
}