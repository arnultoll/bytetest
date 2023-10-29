package com.example.bytetest.di

import android.content.Context
import androidx.room.Room
import com.example.bytetest.dataBase.RegisterDataBaseDao
import com.example.bytetest.dataBase.RegisterDatabas
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val USE_DATABASE_NAME = "user_details_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RegisterDatabas::class.java, USE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: RegisterDatabas) = db.getRegisterDataBaseDao()
}