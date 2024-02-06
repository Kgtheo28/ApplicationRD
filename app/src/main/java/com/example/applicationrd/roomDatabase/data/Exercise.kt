package com.example.applicationrd.roomDatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class Exercise(
    val exerciseName: String,
    val bodyPart: String,

    @PrimaryKey(autoGenerate = true)
    val id : Int
)