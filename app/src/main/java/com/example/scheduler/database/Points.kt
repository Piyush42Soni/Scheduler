package com.example.scheduler.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.hilt.android.HiltAndroidApp
import java.time.LocalTime

@Entity(tableName = "points")
data class Points(
    @PrimaryKey(autoGenerate = true)
    val uid: Int=0,
    @ColumnInfo(name = "Date")
    val Date: String?,
    @ColumnInfo(name = "Calories_burnt")
    val Calories_burnt: String?,
    @ColumnInfo(name="ScreenTime")
    val ScreenTime:Float,
    @ColumnInfo(name="Coding_Questions")
    val Coding_Questions:Int,
    @ColumnInfo(name="CollegeStudy")
    val CollegeStudy:Float,
    @ColumnInfo(name="Wake_Up")
    val Wake:Int,
    @ColumnInfo(name="NP")
    val NP:Boolean,
    @ColumnInfo(name="Book")
    val Book:Boolean
    )