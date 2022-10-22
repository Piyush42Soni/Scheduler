package com.example.scheduler.database

import android.content.Context
import androidx.room.*

@Database(entities = [Points::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterHai::class)
abstract class PointsDatabase : RoomDatabase() {
    abstract val pointsDatabaseDao: PointsDAO
}
