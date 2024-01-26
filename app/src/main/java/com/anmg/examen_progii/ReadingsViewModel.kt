package com.anmg.examen_progii

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import kotlinx.coroutines.launch

class ReadingsViewModel(private val readingsDao:ReadingsDao):ViewModel(){
    val allReadings : LiveData<List<Readings>> = readingsDao.getAllItems().asLiveData()

    fun insertingReadings(readings: Readings){
        viewModelScope.launch {
            readingsDao.insert(readings)
        }
    }
}