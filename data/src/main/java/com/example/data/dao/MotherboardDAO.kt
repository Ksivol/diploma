package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MotherboardDAO {
    @Query("SELECT * FROM motherboard")
    fun getMotherboards(): Flow<List<MotherboardEntity>>

    @Query("SELECT * FROM motherboard WHERE id = :id")
    suspend fun getMotherboard(id : Int): MotherboardEntity

    @Insert
    suspend fun insertMotherboard(motherboard: MotherboardEntity)

    @Update
    suspend fun updateMotherboard(motherboard: MotherboardEntity)

    @Delete
    suspend fun deleteMotherboard(motherboard: MotherboardEntity)
}
