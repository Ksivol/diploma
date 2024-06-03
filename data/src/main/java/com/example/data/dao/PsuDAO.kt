package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PSU
import kotlinx.coroutines.flow.Flow

@Dao
interface PsuDAO {

    @Query("SELECT * FROM psus")
    fun getPsus(): Flow<List<PSU>>

    @Insert
    fun insertPsu(psu: PSU)

    @Update
    fun updatePsu(psu: PSU)

    @Delete
    fun deletePsu(psu: PSU)
}