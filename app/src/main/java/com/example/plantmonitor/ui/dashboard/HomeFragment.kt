package com.example.plantmonitor.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.FragmentHomeBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private val AUTH_REQUEST_CODE = 69

    private val viewModel: DashboardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home, container, false)

        binding.btnLogin.setOnClickListener { view : View ->
            login()
        }

        binding.btnSignup.setOnClickListener { view : View ->
            login()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                DashboardViewModel.AuthenticationState.AUTHENTICATED -> navController.navigate(HomeFragmentDirections.actionHomeFragmentToDashboardFragment())
            }
        })

    }

    private fun login() {

        // Choose authentication providers
        var providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(), AUTH_REQUEST_CODE
        )

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
            if (requestCode == AUTH_REQUEST_CODE) {
                viewModel.user = FirebaseAuth.getInstance().currentUser
                viewModel.authenticationState.value = DashboardViewModel.AuthenticationState.AUTHENTICATED
            }
    }

}