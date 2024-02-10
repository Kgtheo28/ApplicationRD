package com.example.applicationrd.roomDatabase.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)

}

@Dao
interface WeekdayDao {

    @Query("SELECT * FROM weekday_table ORDER BY weekdayId ASC")
    fun readAllData2(): List<Weekday>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeekday(weekday: Weekday)
}