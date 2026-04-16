package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.CPUEntity
import com.example.data.entities.HardDriveEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HardDriveDAO {
    @Query("SELECT * FROM hard_drive")
    fun getHardDrives(): Flow<List<HardDriveEntity>>

    @Query("SELECT * FROM hard_drive WHERE id = :id")
    suspend fun getHardDrive(id : Int): HardDriveEntity

    @Insert
    suspend fun insertHardDrive(hardDrive: HardDriveEntity)

    @Update
    suspend fun updateHardDrive(hardDrive: HardDriveEntity)

    @Delete
    suspend fun deleteHardDrive(hardDrive: HardDriveEntity)
}
