package com.example.scheduler.fragments

import androidx.lifecycle.ViewModel
import com.example.scheduler.database.Points
import com.example.scheduler.database.repo.PointsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MonthlyViewModel @Inject constructor(
    private val repository: PointsRepo
): ViewModel() {
    suspend fun Delete(points: Points){
        return repository.Delete(points)
    }
    suspend fun getAll() = repository.getAll()
    suspend fun Find(date: String) = repository.Find(date)
}