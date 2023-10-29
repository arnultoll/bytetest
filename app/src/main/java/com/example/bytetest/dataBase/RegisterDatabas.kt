package com.example.bytetest.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterEntity::class], version = 1)
abstract class RegisterDatabas: RoomDatabase() {

    abstract fun getRegisterDataBaseDao():RegisterDataBaseDao
}