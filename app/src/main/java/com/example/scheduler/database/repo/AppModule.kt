/*
 * Copyright (c) 2022.
 * All Rights Reserved
 */

package com.example.scheduler.database.repo

import android.content.Context
import androidx.room.Room
import com.example.scheduler.database.PointsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        PointsDatabase::class.java,
        "Points_DB"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: PointsDatabase) =
        db.pointsDatabaseDao // The reason we can implement a Dao for the database
}