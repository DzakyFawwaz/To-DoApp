package com.jaki.example.to_doapp

import androidx.room.TypeConverter
import com.jaki.example.to_doapp.data.model.Priority

class Converter {

    @TypeConverter
    fun fromPriorit(priority: Priority) : String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String) : Priority{
        return Priority.valueOf(priority)
    }
}