package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PSUEntity
import com.example.data.entities.RAMEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RamDAO {
    @Query("SELECT * FROM rams")
    fun getRams(): Flow<List<RAMEntity>>

    @Query("SELECT * FROM rams WHERE id = :id")
    fun getRam(id : Int): RAMEntity

    @Insert
    fun insertRam(ram: RAMEntity)

    @Update
    fun updateRam(ram: RAMEntity)

    @Delete
    fun deleteRam(ram: RAMEntity)
}
