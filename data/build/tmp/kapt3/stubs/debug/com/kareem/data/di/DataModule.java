package com.kareem.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/kareem/data/di/DataModule;", "", "()V", "provideAuthRepository", "Lcom/kareem/domain/repositories/auth/AuthRepository;", "provideGetProductsListUseCase", "Lcom/kareem/domain/useCases/products/GetProductsListUseCase;", "provideLoginUseCase", "Lcom/kareem/domain/useCases/auth/LoginUseCase;", "provideProductsRepository", "Lcom/kareem/domain/repositories/products/ProductsRepository;", "provideServiceApi", "Lcom/kareem/data/remote/ApiInterface;", "data_debug"})
@dagger.Module()
public final class DataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.kareem.data.di.DataModule INSTANCE = null;
    
    private DataModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kareem.data.remote.ApiInterface provideServiceApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kareem.domain.repositories.auth.AuthRepository provideAuthRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kareem.domain.useCases.auth.LoginUseCase provideLoginUseCase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kareem.domain.repositories.products.ProductsRepository provideProductsRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kareem.domain.useCases.products.GetProductsListUseCase provideGetProductsListUseCase() {
        return null;
    }
}