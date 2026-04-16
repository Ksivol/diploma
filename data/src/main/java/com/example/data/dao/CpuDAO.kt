package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CpuDAO {
    @Query("SELECT * FROM cpu")
    fun getCpus(): Flow<List<CPUEntity>>

    @Query("SELECT * FROM cpu WHERE id = :id")
    suspend fun getCpu(id : Int): CPUEntity

    @Insert
    suspend fun insertCpu(cpu: CPUEntity)

    @Update
    suspend fun updateCpu(cpu: CPUEntity)

    @Delete
    suspend fun deleteCpu(cpu: CPUEntity)
}
