package com.example.plantmonitor.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.FragmentDashboardBinding
import com.firebase.ui.auth.AuthUI

class
DashboardFragment : Fragment() {

    private lateinit var binding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDashboardBinding>(inflater,
            R.layout.fragment_dashboard, container, false)
        binding.vm = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

/*        binding.btnLogout.setOnClickListener { view : View ->
            logout()
        }*/

        return binding.root
    }

/*    private fun logout() {
        context?.let {
            AuthUI.getInstance()
                .signOut(it)
                .addOnCompleteListener {
                    binding.vm!!.authenticationState.value = DashboardViewModel.AuthenticationState.UNAUTHENTICATED
                }
        }
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm!!.listenToPlants()

/*        val navController = findNavController()
        binding.vm!!.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                DashboardViewModel.AuthenticationState.UNAUTHENTICATED -> navController.navigate(DashboardFragmentDirections.actionDashboardFragmentToHomeFragment())
            }
        })*/
    }
}