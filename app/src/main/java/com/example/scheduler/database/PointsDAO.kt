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
    fun insertAll(Points: List<Points>)
    @Delete
    fun delete(points: Points)
}