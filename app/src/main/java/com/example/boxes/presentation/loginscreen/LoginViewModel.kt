package com.example.boxes.presentation.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  //  private val loginRepository : LoginRepository

) : ViewModel() {
    private var joBa : Job? =null

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onMailChanged(string: String){
        _state.value =_state.value.copy(mail = string)
    }
    fun onNameChanged(string :String){
        _state.value =_state.value.copy(name = string)
    }
    fun onPasswordChanged(string: String){
        _state.value =_state.value.copy(password = string)
    }
    fun onRepeatedPasswordChanged(string: String){
        _state.value =_state.value.copy(repeatedPassword = string)
    }
    fun onLogin(){
        joBa?.cancel()
        joBa = viewModelScope.launch {

        }
    }
    fun onRegister(){
        joBa?.cancel()
        joBa = viewModelScope.launch {

        }
    }
}