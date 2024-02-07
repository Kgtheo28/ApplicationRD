package com.example.applicationrd.roomDatabase.repository

import androidx.lifecycle.LiveData
import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.data.ExerciseDao
import com.example.applicationrd.roomDatabase.weekdayData.Weekday
import com.example.applicationrd.roomDatabase.weekdayData.WeekdayDao

class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    //val readAllData: List<Exercise> = exerciseDao.readAllData()
    //val readAllData2: List<Weekday> = weekdayDao.readAllData2()

    suspend fun addExercise(exercise: Exercise){
        exerciseDao.addExercise(exercise)
    }

    /*
    suspend fun addWeekday(weekday: Weekday){
        weekdayDao.addWeekday(weekday)
    }
     */

}