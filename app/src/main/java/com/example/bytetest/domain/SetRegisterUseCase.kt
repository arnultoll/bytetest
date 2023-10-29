package com.example.bytetest.domain

import com.example.bytetest.dataBase.RegisterEntity
import com.example.bytetest.dataBase.RegisterRepository
import com.example.bytetest.dataBase.toDataBase
import com.example.bytetest.domain.model.User
import com.example.bytetest.domain.model.toDomain
import javax.inject.Inject

class SetRegisterUseCase @Inject constructor(private val repository: RegisterRepository){
    suspend  fun setRegister(user: User){
        repository.insert(user.toDataBase())
    }
}