package com.example.plantmonitor.ui.dashboard;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.data.models.PlantItem
import com.example.plantmonitor.databinding.DashboardActivityBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class DashboardActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : DashboardViewModelFactory by instance<DashboardViewModelFactory>()

    private lateinit var viewModel: DashboardViewModel
    private lateinit var plantData: PlantItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        val binding: DashboardActivityBinding = DataBindingUtil.setContentView(this, R.layout.dashboard_activity)
        viewModel = ViewModelProvider(this, this.factory).get(DashboardViewModel::class.java)
        binding.vm = viewModel

        viewModel.plant.observe(this ,Observer {
                plants -> this.plantData = plants
            updateHumidityValue()
        })
    }

    /** Methods for updating the UI **/
    private fun updateHumidityValue() {
        viewModel.humidity = plantData.humidity.toString()
    }

}
