package com.example.scheduler.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [points::class], version = 1)
abstract class PointsDataBase: RoomDatabase() {
    abstract fun userDao(): Points_DAO

}