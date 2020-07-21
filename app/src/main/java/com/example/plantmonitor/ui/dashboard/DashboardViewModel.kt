package com.example.plantmonitor.ui.dashboard

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plantmonitor.data.models.PlantItem
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class DashboardViewModel () : ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
    }

    var user : FirebaseUser? = null
    var authenticationState = MutableLiveData<AuthenticationState>()

    private var firestore : FirebaseFirestore
    var humidity: MutableLiveData<Int> = MutableLiveData()

    init {
        Log.i("ViewModel", "ViewModel created")
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        firestore = FirebaseFirestore.getInstance()
        listenToPlants()
    }

    /**
     * This will hear any updates from Firestore
     */
    fun listenToPlants() {
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
                    humidity.postValue(humidity.value)
                }
                Log.i(TAG, "observe change: " + humidity.value)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed")
    }

}