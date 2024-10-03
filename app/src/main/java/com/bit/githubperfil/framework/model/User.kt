package com.bit.githubperfil.framework.model

import com.google.gson.annotations.SerializedName

/**
 * @Author:  Vitor Rey
 * @Date: 25,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
data class User(
    val login: String,
    val id: Long,
    val url: String,
    val name: String,
    val company: String,
    val bio: String,
    @SerializedName("public_repos")
    val repos: Int,
    @SerializedName("avatar_url")
    val avatar: String,
)
