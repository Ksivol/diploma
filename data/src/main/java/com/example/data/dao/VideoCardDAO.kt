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
    @Query("SELECT * FROM video_cards")
    fun getVideoCards(): Flow<List<VideoCardEntity>>

    @Query("SELECT * FROM video_cards WHERE id = :id")
    fun getVideoCard(id : Int): VideoCardEntity

    @Insert
    fun insertVideoCard(videoCard: VideoCardEntity)

    @Update
    fun updateVideoCard(videoCard: VideoCardEntity)

    @Delete
    fun deleteVideoCard(videoCard: VideoCardEntity)
}
