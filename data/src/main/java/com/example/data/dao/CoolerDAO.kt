package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.Cooler
import kotlinx.coroutines.flow.Flow

@Dao
interface CoolerDAO {

    @Query("SELECT * FROM coolers")
    fun getCoolers(): Flow<List<Cooler>>

    @Insert
    fun insertCooler(cooler: Cooler)

    @Update
    fun updateCooler(cooler: Cooler)

    @Delete
    fun deleteCooler(cooler: Cooler)
}