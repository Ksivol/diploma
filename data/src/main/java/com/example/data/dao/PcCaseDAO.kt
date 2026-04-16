package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PcCaseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PcCaseDAO {
    @Query("SELECT * FROM pc_case")
    fun getPcCases(): Flow<List<PcCaseEntity>>

    @Query("SELECT * FROM pc_case WHERE id = :id")
    suspend fun getPcCase(id : Int): PcCaseEntity

    @Insert
    suspend fun insertPcCase(pcCase: PcCaseEntity)

    @Update
    suspend fun updatePcCase(pcCase: PcCaseEntity)

    @Delete
    suspend fun deletePcCase(pcCase: PcCaseEntity)
}
