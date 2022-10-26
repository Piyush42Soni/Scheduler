/*
 * Copyright (c) 2022.
 * All Rights Reserved
 */

package com.example.scheduler.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PointsDAO {
    @Query("SELECT * FROM points order by datetime(Date) limit 30")
    fun getAll(): List<Points>
    @Query("SELECT * FROM points order by datetime(Date) desc limit 1")
    fun getone(): Points
    @Insert
    fun insert(points: Points)
    @Delete
    fun delete(points: Points)
    @Query("SELECT * FROM points where Date=:data LIMIT 1")
    fun find(data:String):Points
}