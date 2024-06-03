package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.VideoCard
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoCardDAO {

    @Query("SELECT * FROM video_cards")
    fun getVideoCards(): Flow<List<VideoCard>>

    @Insert
    fun insertVideoCard(videoCard: VideoCard)

    @Update
    fun updateVideoCard(videoCard: VideoCard)

    @Delete
    fun deleteVideoCard(videoCard: VideoCard)
}