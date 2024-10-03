package com.bit.githubperfil.framework.network

import com.bit.githubperfil.framework.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @Author:  Vitor Rey
 * @Date: 25,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
interface UserService {

    @GET("/users")
    suspend fun getUsers(@Query("per_page") perPage: Int, @Query("page") page: Int): Response<List<User>>

    @GET("/users/{username}")
    suspend fun getUser(@Path("username") username: String) : Response<User>
}