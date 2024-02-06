package com.example.applicationrd.roomDatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)

    /*
    @Query("SELECT * FROM exercise_table ORDER BY id ASC")
    fun readAllData(): List<Exercise>

     */


}