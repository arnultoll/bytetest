package com.example.bytetest.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bytetest.domain.model.User

@Entity(tableName = "tabla_usuarios")
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "primer_nombre")
    var primer_nombre: String,

    @ColumnInfo(name = "segundo_nombre")
    var segundo_nombre: String,

    @ColumnInfo(name = "primer_apellido")
    var primer_apellido: String,

    @ColumnInfo(name = "segundo_apellido")
    var segundo_apellido: String,

    @ColumnInfo(name = "nombre_usuario")
    var nombre_usuario: String,

    @ColumnInfo(name = "password_text")
    var passwrd: String
)

    fun User.toDataBase()= RegisterEntity(0,firstName,secondName,lastName,
        secondLastName,userName,passwrd)