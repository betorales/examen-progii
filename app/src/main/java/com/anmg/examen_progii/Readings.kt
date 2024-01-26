package com.anmg.examen_progii

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "readings")
data class Readings(
    @PrimaryKey(autoGenerate = true)
    val id : Long?,
    val meter: Int,
    val typeOfMeter: String,
    val dateOfReading: String
) {
}