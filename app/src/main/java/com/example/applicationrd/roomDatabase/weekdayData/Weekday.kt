package com.example.applicationrd.roomDatabase.weekdayData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weekday_table")
data class Weekday(
    val weekdayName: String,

    @PrimaryKey(autoGenerate = true)
    val weekdayId : Int
)