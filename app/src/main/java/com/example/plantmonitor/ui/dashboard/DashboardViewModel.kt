package com.example.plantmonitor.ui.dashboard

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plantmonitor.data.models.PlantItem
import com.example.plantmonitor.data.repositories.UserRepository
import com.example.plantmonitor.utils.startLoginActivity
import com.google.firebase.firestore.FirebaseFirestore


class DashboardViewModel (
    private val repository: UserRepository
) : ViewModel() {

    private var firestore : FirebaseFirestore
    var humidity: MutableLiveData<Int> = MutableLiveData()

    init {
        Log.i("ViewModel", "ViewModel created")
        firestore = FirebaseFirestore.getInstance()
        listenToPlants()
    }

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }

    /**
     * This will hear any updates from Firestore
     */
    private fun listenToPlants() {
        firestore.collection("plant_data")
            .document("plant_0")
            .addSnapshotListener {
            snapshot, e ->
            // if there is an exception, then skip
            if (e != null) {
                Log.w(TAG, "listen Failed", e)
                return@addSnapshotListener
            }
            // if we are here, we didn't encounter exception
            if (snapshot != null) {
                // we have a snapshot
                val plant = snapshot.toObject(PlantItem::class.java)

                if (plant != null) {
                    humidity.value = plant.humidity
                }
                humidity.postValue(humidity.value)

                Log.i(TAG, "observe change: " + humidity.value)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed")
    }

    fun gototemp(view: android.view.View) {
        Intent(view.context, TempuratureActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
    fun gotomos(view: android.view.View) {
        Intent(view.context, MostureActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
    fun gotoLight(view: android.view.View) {
        Intent(view.context, LightActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
    fun gohome(view: android.view.View) {
        Intent(view.context, DashboardActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


}