package com.example.bytetest.register

import android.app.Application
import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bytetest.dataBase.RegisterEntity
import com.example.bytetest.dataBase.RegisterRepository
import com.example.bytetest.domain.SetRegisterUseCase
import com.example.bytetest.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val setRegisterUseCase: SetRegisterUseCase
):ViewModel() {
 fun saveRegister(user: User){
     CoroutineScope(Dispatchers.IO).launch {
         setRegisterUseCase.setRegister(user)
     }
 }

}
