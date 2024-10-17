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
    @Query("SELECT * FROM hard_drives")
    fun getHardDrives(): Flow<List<HardDriveEntity>>

    @Query("SELECT * FROM hard_drives WHERE id = :id")
    fun getHardDrive(id : Int): HardDriveEntity

    @Insert
    fun insertHardDrive(hardDrive: HardDriveEntity)

    @Update
    fun updateHardDrive(hardDrive: HardDriveEntity)

    @Delete
    fun deleteHardDrive(hardDrive: HardDriveEntity)
}
