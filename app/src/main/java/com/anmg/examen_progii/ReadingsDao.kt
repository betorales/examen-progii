package com.anmg.examen_progii

import android.media.RouteListingPreference
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingsDao {
    //@Upsert opción si se quiere modificar sobre el mismo
    @Insert
    suspend fun insert(readings: Readings)

    @Update
    suspend fun update(readings: Readings)

    @Delete
    suspend fun delete(readings: Readings)

    //Revisa su correcta implementación antes de usar
    //Queda comentado
    /*@Query("SELECT * from readings WHERE id = :id")
    fun getItem(id: Int): Flow<Readings>*/

    @Query("SELECT * from readings ORDER BY id ASC")
    fun getAllItems(): Flow<List<Readings>>
}