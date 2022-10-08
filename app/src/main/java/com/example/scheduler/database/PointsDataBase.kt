package com.example.scheduler.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Points::class], version = 1)
abstract class PointsDataBase: RoomDatabase() {
    abstract fun userDao(): PointsDAO

}