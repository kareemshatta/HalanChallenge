package com.kareem.data.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kareem.data.remote.ApiInterface
import com.kareem.data.repositories_imp.auth.AuthRepositoryImpl
import com.kareem.data.repositories_imp.products.ProductsRepositoryImpl
import com.kareem.data.utils.Constants
import com.kareem.domain.repositories.auth.AuthRepository
import com.kareem.domain.repositories.products.ProductsRepository
import com.kareem.domain.useCases.auth.LoginUseCase
import com.kareem.domain.useCases.products.GetProductsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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

    @Provides
    @Singleton
    fun provideProductsRepository(): ProductsRepository =
        ProductsRepositoryImpl(provideServiceApi())

    @Provides
    @Singleton
    fun provideGetProductsListUseCase() =
        GetProductsListUseCase(provideProductsRepository())
}