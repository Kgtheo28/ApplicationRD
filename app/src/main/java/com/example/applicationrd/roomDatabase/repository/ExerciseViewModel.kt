package com.example.applicationrd.roomDatabase.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.applicationrd.roomDatabase.ExerciseDatabase
import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.weekdayData.Weekday
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel(application: Application): AndroidViewModel(application) {

    //private val readAllData: List<Exercise>
    //private val readAllData2: List<Weekday>
    private val repository: ExerciseRepository

    init{
        val exerciseDao = ExerciseDatabase.getDatabase(application).exerciseDao()
        //val weekdayDao = ExerciseDatabase.getDatabase(application).weekdayDoa()
        repository = ExerciseRepository(exerciseDao)
        //readAllData = repository.readAllData
        //readAllData2 = repository.readAllData2
    }

    fun addExercise(exercise: Exercise){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExercise(exercise)
        }
    }



    /*
    fun addWeekday(weekday: Weekday){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWeekday(weekday)
        }
    }

     */

}