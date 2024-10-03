package com.bit.githubperfil.framework.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bit.githubperfil.framework.model.User
import com.bit.githubperfil.framework.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.State

/**
 * @Author:  Vitor Rey
 * @Date: 28,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
class GitViewModel(private val repository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<User>>(UiState.Loading)
    val uiState: StateFlow<UiState<User>> = _uiState

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            try {
                repository.getUser()!!.also {
                    Log.i(this@GitViewModel.javaClass.simpleName, it.toString())
                    _uiState.value = UiState.Success(it)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message!!)
            }
        }
    }

}