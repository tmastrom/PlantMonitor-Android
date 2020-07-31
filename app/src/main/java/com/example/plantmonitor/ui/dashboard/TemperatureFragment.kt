package com.example.plantmonitor.ui.dashboard;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.FragmentTemperatureBinding
import kotlinx.android.synthetic.main.fragment_temperature.view.*

class TemperatureFragment : Fragment() {

    private lateinit var binding : FragmentTemperatureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentTemperatureBinding>(
            inflater,
            R.layout.fragment_temperature, container, false
        )
        binding.vm = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnBack.setOnClickListener { view: View ->
            view.findNavController().navigate(TemperatureFragmentDirections.actionTempuratureFragmentToDashboardFragment())
        }
        return binding.root
    }

}
