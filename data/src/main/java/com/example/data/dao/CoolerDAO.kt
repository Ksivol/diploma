package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.CoolerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoolerDAO {
    @Query("SELECT * FROM coolers")
    fun getCoolers(): Flow<List<CoolerEntity>>

    @Insert
    fun insertCooler(cooler: CoolerEntity)

    @Update
    fun updateCooler(cooler: CoolerEntity)

    @Delete
    fun deleteCooler(cooler: CoolerEntity)
}
