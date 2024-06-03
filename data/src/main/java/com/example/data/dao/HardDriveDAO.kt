package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.HardDrive
import kotlinx.coroutines.flow.Flow

@Dao
interface HardDriveDAO {

    @Query("SELECT * FROM hard_drives")
    fun getHardDrives(): Flow<List<HardDrive>>

    @Insert
    fun insertHardDrive(hardDrive: HardDrive)

    @Update
    fun updateHardDrive(hardDrive: HardDrive)

    @Delete
    fun deleteHardDrive(hardDrive: HardDrive)
}