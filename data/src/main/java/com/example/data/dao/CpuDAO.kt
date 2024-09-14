package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.CPUEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CpuDAO {
    @Query("SELECT * FROM cpus")
    fun getCpus(): Flow<List<CPUEntity>>

    @Insert
    fun insertCpu(cpu: CPUEntity)

    @Update
    fun updateCpu(cpu: CPUEntity)

    @Delete
    fun deleteCpu(cpu: CPUEntity)
}
