package com.example.jetnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnote.model.Note
import com.example.jetnote.util.Converters

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    Converters::class
)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}