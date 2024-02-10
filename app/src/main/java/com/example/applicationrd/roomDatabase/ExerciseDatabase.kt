package com.example.applicationrd.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.data.ExerciseDao
import com.example.applicationrd.roomDatabase.data.ExerciseWeekdayCrossRef
import com.example.applicationrd.roomDatabase.data.ExerciseWeekdayCrossRefDao
import com.example.applicationrd.roomDatabase.data.Weekday
import com.example.applicationrd.roomDatabase.data.WeekdayDao

@Database(entities = [
    Exercise::class,
    Weekday::class,
    ExerciseWeekdayCrossRef::class], version =1, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun weekdayDoa(): WeekdayDao
    abstract fun exerciseWeekdayCrossRefDao(): ExerciseWeekdayCrossRefDao

    companion object {
        @Volatile
        private var INSTANCE: ExerciseDatabase? = null

        fun getDatabase(context: Context): ExerciseDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExerciseDatabase::class.java,
                    "exercise_and_Weekdays_cross_ref_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}