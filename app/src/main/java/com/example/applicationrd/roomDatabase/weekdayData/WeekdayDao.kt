package com.example.applicationrd.roomDatabase.weekdayData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeekdayDao {

    @Query("SELECT * FROM weekday_table ORDER BY weekdayId ASC")
    fun readAllData2(): List<Weekday>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeekday(weekday: Weekday)
}