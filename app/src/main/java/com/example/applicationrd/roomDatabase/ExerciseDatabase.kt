package com.example.applicationrd.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.data.ExerciseDao
import com.example.applicationrd.roomDatabase.data.Weekday
import com.example.applicationrd.roomDatabase.data.WeekdayDao

@Database(entities = [Exercise::class, Weekday::class], version =1, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun weekdayDoa(): WeekdayDao

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
                    "exercise_ with_Weekdays_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}