package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.RAM
import kotlinx.coroutines.flow.Flow

@Dao
interface RamDAO {

    @Query("SELECT * FROM rams")
    fun getRams(): Flow<List<RAM>>

    @Insert
    fun insertRam(ram: RAM)

    @Update
    fun updateRam(ram: RAM)

    @Delete
    fun deleteRam(ram: RAM)
}