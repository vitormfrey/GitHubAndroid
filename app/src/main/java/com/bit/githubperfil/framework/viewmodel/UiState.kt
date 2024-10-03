package com.bit.githubperfil.framework.viewmodel

/**
 * @Author:  Vitor Rey
 * @Date: 28,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}