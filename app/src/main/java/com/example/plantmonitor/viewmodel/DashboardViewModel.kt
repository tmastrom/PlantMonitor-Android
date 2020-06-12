package com.example.plantmonitor.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plantmonitor.database.PlantItem
import com.google.firebase.firestore.FirebaseFirestore

class DashboardViewModel : ViewModel() {

    private lateinit var firestore : FirebaseFirestore

    private var _plant: MutableLiveData<PlantItem> = MutableLiveData<PlantItem>()

    init {
        Log.i("ViewModel", "ViewModel created")
        firestore = FirebaseFirestore.getInstance()
        listenToPlants()
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
                _plant.value = plant

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed")
    }

    internal var plant : MutableLiveData<PlantItem>
        get() { return _plant}
        set(value) {_plant = value}

}