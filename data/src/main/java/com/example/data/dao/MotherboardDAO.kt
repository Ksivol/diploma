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
    @Query("SELECT * FROM motherboards")
    fun getMotherboards(): Flow<List<MotherboardEntity>>

    @Query("SELECT * FROM motherboards WHERE id = :id")
    fun getMotherboard(id : Int): MotherboardEntity

    @Insert
    fun insertMotherboard(motherboard: MotherboardEntity)

    @Update
    fun updateMotherboard(motherboard: MotherboardEntity)

    @Delete
    fun deleteMotherboard(motherboard: MotherboardEntity)
}
