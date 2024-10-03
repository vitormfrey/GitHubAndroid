package com.bit.githubperfil.framework.repository

import com.bit.githubperfil.framework.model.User
import com.bit.githubperfil.framework.network.UserService

/**
 * @Author:  Vitor Rey
 * @Date: 25,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun getUsers() = userService.getUsers(1, 1).body()

    override suspend fun getUser() = userService.getUser("vitormfrey").body()
}