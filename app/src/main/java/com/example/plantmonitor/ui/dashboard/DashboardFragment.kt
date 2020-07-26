package com.example.plantmonitor.ui.dashboard

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        binding.temperatureCardView.setOnClickListener { view: View ->
            Log.i(TAG, "onCreateView: navigate to temp")
            view.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToTempuratureFragment())

        }

        // Todo: Make this work
        // Problem is Authentication state is not changed so when the home fragment is inflated, AUTH state is observed as Authenticated and navigates to Dashboard fragment
        binding.btnLogout.setOnClickListener { view : View ->
            AuthUI.getInstance().signOut(view.context)
                .addOnCompleteListener {
                    if (it.isComplete){
                        if (it.isSuccessful){
                            binding.vm!!.authenticationState.value = DashboardViewModel.AuthenticationState.UNAUTHENTICATED

                        }
                        else if (it.isCanceled) {
                            Toast.makeText(view.context, "Sign Out Failed", Toast.LENGTH_SHORT).show()
                        }
                        view.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToHomeFragment())
                    }
                }
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm!!.listenToPlants()
    }
}