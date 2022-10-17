package com.example.scheduler.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PointsDAO {
    @Query("SELECT * FROM points")
    fun getAll(): List<Points>
    @Insert
    fun insert(points: Points)
    @Delete
    fun delete(points: Points)
    @Query("SELECT * FROM points where Date=:data LIMIT 1")
    fun find(data:String):Points
}