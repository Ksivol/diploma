package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PcEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PcDAO {
    @Query("SELECT * FROM Pc")
    fun getPc(): Flow<List<PcEntity>>

    @Insert
    fun insertPc(pc: PcEntity)

    @Update
    fun updatePc(pc: PcEntity)

    @Delete
    fun deletePc(pc: PcEntity)
}