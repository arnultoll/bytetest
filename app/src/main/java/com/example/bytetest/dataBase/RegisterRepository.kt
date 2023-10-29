package com.example.bytetest.dataBase

import com.example.bytetest.dataBase.RegisterDataBaseDao
import com.example.bytetest.dataBase.RegisterEntity
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val dao: RegisterDataBaseDao)  {
    //val users = dao.getAll()

     fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

     fun getUserName(userName: String): RegisterEntity?{
        return dao.findByUserName(userName)
    }


}