package com.example.scheduler.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Points_DAO {
    @Query("SELECT * FROM points")
    fun getAll(): List<points>
    @Insert
    fun insertAll(Points: List<points>)
    @Delete
    fun delete(Points: points)
}