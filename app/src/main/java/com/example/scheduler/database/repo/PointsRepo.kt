package com.example.scheduler.database.repo

import com.example.scheduler.database.Points
import com.example.scheduler.database.PointsDAO
import javax.inject.Inject

class PointsRepo @Inject constructor(
    private val pointsDAO: PointsDAO
){
    suspend fun getAll() = pointsDAO.getAll()
    suspend fun insertAll(points: Points) = pointsDAO.insert(points)
    suspend fun Delete(points: Points) = pointsDAO.delete(points)
    suspend fun Find(date: String) = pointsDAO.find(date)
    suspend fun getone()=pointsDAO.getone()
}