package com.example.plantmonitor.screens.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.database.PlantItem
import com.example.plantmonitor.databinding.DashboardFragmentBinding
import com.example.plantmonitor.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var  binding : DashboardFragmentBinding
    private lateinit var plantData: PlantItem


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.dashboard_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        viewModel.plant.observe(viewLifecycleOwner, Observer {
            plants -> this.plantData = plants
            updateHumidityValue()
        })
        return binding.root
    }

    /** Methods for updating the UI **/
    private fun updateHumidityValue() {
        binding.humidityValue.text = plantData.humidity.toString()
    }


}