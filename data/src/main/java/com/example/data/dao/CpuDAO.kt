package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.CPU
import kotlinx.coroutines.flow.Flow

@Dao
interface CpuDAO {

    @Query("SELECT * FROM cpus")
    fun getCpus(): Flow<List<CPU>>

    @Insert
    fun insertCpu(cpu: CPU)

    @Update
    fun updateCpu(cpu: CPU)

    @Delete
    fun deleteCpu(cpu: CPU)
}