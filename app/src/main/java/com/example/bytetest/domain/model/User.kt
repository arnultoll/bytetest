package com.example.bytetest.domain.model

import com.example.bytetest.dataBase.RegisterEntity

data class User(val firstName: String, val secondName: String,
    val lastName: String, val secondLastName: String, val userName: String,
    val passwrd: String)

    fun RegisterEntity.toDomain()= User(primer_nombre,segundo_nombre,primer_apellido,
        segundo_apellido,nombre_usuario,passwrd)