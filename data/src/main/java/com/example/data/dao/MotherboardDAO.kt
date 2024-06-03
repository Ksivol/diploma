package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.Motherboard
import kotlinx.coroutines.flow.Flow

@Dao
interface MotherboardDAO {

    @Query("SELECT * FROM motherboards")
    fun getMotherboards(): Flow<List<Motherboard>>

    @Insert
    fun insertMotherboard(motherboard: Motherboard)

    @Update
    fun updateMotherboard(motherboard: Motherboard)

    @Delete
    fun deleteMotherboard(motherboard: Motherboard)
}