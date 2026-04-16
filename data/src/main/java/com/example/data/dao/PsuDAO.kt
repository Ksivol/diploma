package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PSUEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PsuDAO {
    @Query("SELECT * FROM psu")
    fun getPsu(): Flow<List<PSUEntity>>

    @Query("SELECT * FROM psu WHERE id = :id")
    suspend fun getPsu(id: Int): PSUEntity

    @Insert
    suspend fun insertPsu(psu: PSUEntity)

    @Update
    suspend fun updatePsu(psu: PSUEntity)

    @Delete
    suspend fun deletePsu(psu: PSUEntity)
}
