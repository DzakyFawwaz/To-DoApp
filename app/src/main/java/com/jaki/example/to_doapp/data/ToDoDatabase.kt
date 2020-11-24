package com.jaki.example.to_doapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jaki.example.to_doapp.Converter
import com.jaki.example.to_doapp.data.model.ToDoDao
import com.jaki.example.to_doapp.data.model.ToDoData

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase(){

    abstract fun toDoDao(): ToDoDao

    companion object{
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDataBase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}