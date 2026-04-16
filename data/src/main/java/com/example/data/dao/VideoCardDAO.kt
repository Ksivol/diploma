package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.RAMEntity
import com.example.data.entities.VideoCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoCardDAO {
    @Query("SELECT * FROM video_card")
    fun getVideoCards(): Flow<List<VideoCardEntity>>

    @Query("SELECT * FROM video_card WHERE id = :id")
    suspend fun getVideoCard(id : Int): VideoCardEntity

    @Insert
    suspend fun insertVideoCard(videoCard: VideoCardEntity)

    @Update
    suspend fun updateVideoCard(videoCard: VideoCardEntity)

    @Delete
    suspend fun deleteVideoCard(videoCard: VideoCardEntity)
}
