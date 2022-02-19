package com.kareem.data.di

import com.kareem.data.remote.ApiInterface
import com.kareem.data.repositories_imp.AuthRepositoryImpl
import com.kareem.data.utils.Constants
import com.kareem.domain.repositories.AuthRepository
import com.kareem.domain.useCases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideServiceApi(): ApiInterface =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository =
        AuthRepositoryImpl(provideServiceApi())
    
    @Provides
    @Singleton
    fun provideLoginUseCase() =
        LoginUseCase(provideAuthRepository())
}