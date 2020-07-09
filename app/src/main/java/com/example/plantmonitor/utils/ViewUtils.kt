package com.example.plantmonitor.utils

import android.content.Context
import android.content.Intent
import com.example.plantmonitor.ui.auth.LoginActivity
import com.example.plantmonitor.ui.dashboard.DashboardActivity

fun Context.startDashboardActivity() =
    Intent(this, DashboardActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startLoginActivity() =
    Intent(this, LoginActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }