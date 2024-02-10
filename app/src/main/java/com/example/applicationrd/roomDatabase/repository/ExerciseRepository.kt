package com.example.applicationrd.roomDatabase.repository


import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.data.ExerciseDao
import com.example.applicationrd.roomDatabase.data.ExerciseWeekdayCrossRef
import com.example.applicationrd.roomDatabase.data.ExerciseWeekdayCrossRefDao
import com.example.applicationrd.roomDatabase.data.Weekday
import com.example.applicationrd.roomDatabase.data.WeekdayDao

class ExerciseRepository(
    private val exerciseDao: ExerciseDao,
    private val weekdayDao: WeekdayDao,
    private val exerciseWeekdayCrossRefDao: ExerciseWeekdayCrossRefDao) {

    //val readAllData: List<Exercise> = exerciseDao.readAllData()
    //val readAllData2: List<Weekday> = weekdayDao.readAllData2()

    suspend fun addExercise(exercise: Exercise){
        exerciseDao.addExercise(exercise)
    }

    suspend fun addWeekday(weekday: Weekday){
        weekdayDao.addWeekday(weekday)
    }

    suspend fun addCrossRef(exerciseWeekdayCrossRef: ExerciseWeekdayCrossRef){
        exerciseWeekdayCrossRefDao.addCrossRef(exerciseWeekdayCrossRef)
    }

}