package com.example.plantmonitor.screens.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.DashboardFragmentBinding

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: DashboardFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.dashboard_fragment, container, false)
        return binding.root
    }
}