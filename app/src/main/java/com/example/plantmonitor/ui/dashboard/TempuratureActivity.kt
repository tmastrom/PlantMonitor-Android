package com.example.plantmonitor.ui.dashboard;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.ActivityDashboardBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class TempuratureActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : DashboardViewModelFactory by instance<DashboardViewModelFactory>()

    private lateinit var viewModel: DashboardViewModel
    //private lateinit var plantData: PlantItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperature)

        val binding: ActivityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.temperature)
        viewModel = ViewModelProvider(this, factory).get(DashboardViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this

    }

    /** Methods for updating the UI **/
/*    private fun updateHumidityValue() {
        Toast.makeText(this, "update value: " + plantData.humidity.toString() , Toast.LENGTH_SHORT).show()
        viewModel.humidity = plantData.humidity.toString()

    }*/

}
