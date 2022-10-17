package com.example.scheduler.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Points::class], version = 1, exportSchema = false)
abstract class PointsDatabase : RoomDatabase() {
    abstract val pointsDatabaseDao: PointsDAO
}
