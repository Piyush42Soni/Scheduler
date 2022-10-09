package com.example.scheduler.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Points::class], version = 1, exportSchema = false)
abstract class PointsDatabase : RoomDatabase() {
    abstract val pointsDatabaseDao: PointsDAO
    companion object {
        @Volatile
        private var INSTANCE: PointsDatabase? = null
        fun getInstance(context: Context): PointsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PointsDatabase::class.java,
                        "points_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
