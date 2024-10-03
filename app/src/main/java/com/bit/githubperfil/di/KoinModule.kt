package com.bit.githubperfil.di

import com.bit.githubperfil.framework.network.UserService
import com.bit.githubperfil.framework.repository.UserRepository
import com.bit.githubperfil.framework.repository.UserRepositoryImpl
import com.bit.githubperfil.framework.viewmodel.GitViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author:  Vitor Rey
 * @Date: 25,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(UserService::class.java) }
}

val repositoryModule = module { single<UserRepository> { UserRepositoryImpl(get()) } }

val viewmodelModule = module { viewModel<GitViewModel> { GitViewModel(get()) } }

