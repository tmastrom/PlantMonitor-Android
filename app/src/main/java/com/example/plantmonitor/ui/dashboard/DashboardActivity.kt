package com.example.plantmonitor.ui.dashboard;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.ActivityDashboardBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class DashboardActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : DashboardViewModelFactory by instance<DashboardViewModelFactory>()

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Dashboard Activity", "Called onCreate")

        viewModel = ViewModelProvider(this, factory).get(DashboardViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}
