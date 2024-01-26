package com.anmg.examen_progii

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Readings::class], version = 1, exportSchema = false)
abstract class ReadingsDatabase : RoomDatabase(){

    abstract fun readingsDao():ReadingsDao

    companion object{
        @Volatile
        private var Instance: ReadingsDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context):ReadingsDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, ReadingsDatabase::class.java, "readingsDatabase")
                    .build()
                    .also{ Instance = it}
            }
        }
    }
}