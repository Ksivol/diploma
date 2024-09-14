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
    @Query("SELECT * FROM psus")
    fun getPsus(): Flow<List<PSUEntity>>

    @Insert
    fun insertPsu(psu: PSUEntity)

    @Update
    fun updatePsu(psu: PSUEntity)

    @Delete
    fun deletePsu(psu: PSUEntity)
}
