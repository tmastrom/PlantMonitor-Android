package com.example.plantmonitor.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.plantmonitor.screens.dashboard.DashboardFragment

class DashboardViewModel : ViewModel() {

    var humidity = 0

    init {
        Log.i("ViewModel", "ViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed")
    }
}