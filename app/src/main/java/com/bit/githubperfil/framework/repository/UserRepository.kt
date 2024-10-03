package com.bit.githubperfil.framework.repository

import com.bit.githubperfil.framework.model.User

/**
 * @Author:  Vitor Rey
 * @Date: 25,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
interface UserRepository {

    suspend fun getUsers() : List<User>?

    suspend fun getUser() : User?
}