package com.example.bytetest.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bytetest.domain.GetUserUseCase
import com.example.bytetest.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private var _user = MutableLiveData<Boolean>()
    val user: LiveData<Boolean>
        get() = _user

    fun getUser(user: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val user = getUserUseCase.getUser(user)
                if (user != null) {
                    _user.postValue(user.passwrd == password)


                }
            }
        }
    }

}

