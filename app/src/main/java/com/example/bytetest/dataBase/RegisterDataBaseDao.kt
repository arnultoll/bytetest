package com.example.bytetest.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegisterDataBaseDao{
    @Insert
    fun insert(register: RegisterEntity)

    @Query("SELECT * FROM tabla_usuarios ORDER BY userId DESC")
    fun getAll(): List<RegisterEntity>

    @Query("SELECT * FROM tabla_usuarios WHERE nombre_usuario LIKE :userName")
     fun findByUserName(userName: String): RegisterEntity?

    @Query("DELETE FROM tabla_usuarios WHERE userId = :id")
    fun deleteById(id: Int)
}