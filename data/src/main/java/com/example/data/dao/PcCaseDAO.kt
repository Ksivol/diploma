package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PcCase
import kotlinx.coroutines.flow.Flow

@Dao
interface PcCaseDAO {

    @Query("SELECT * FROM pc_cases")
    fun getPcCases(): Flow<List<PcCase>>

    @Insert
    fun insertPcCase(pcCase: PcCase)

    @Update
    fun updatePcCase(pcCase: PcCase)

    @Delete
    fun deletePcCase(pcCase: PcCase)
}