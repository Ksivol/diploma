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
    @Query("SELECT * FROM pc_cases")
    fun getPcCases(): Flow<List<PcCaseEntity>>

    @Query("SELECT * FROM pc_cases WHERE id = :id")
    fun getPcCase(id : Int): PcCaseEntity

    @Insert
    fun insertPcCase(pcCase: PcCaseEntity)

    @Update
    fun updatePcCase(pcCase: PcCaseEntity)

    @Delete
    fun deletePcCase(pcCase: PcCaseEntity)
}
