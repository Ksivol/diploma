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
    fun getCpu(id : Int): CPUEntity

    @Insert
    fun insertCpu(cpu: CPUEntity)

    @Update
    fun updateCpu(cpu: CPUEntity)

    @Delete
    fun deleteCpu(cpu: CPUEntity)
}
