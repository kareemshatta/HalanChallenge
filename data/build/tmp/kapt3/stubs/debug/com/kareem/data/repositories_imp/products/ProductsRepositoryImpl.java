package com.kareem.data.repositories_imp.products;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/kareem/data/repositories_imp/products/ProductsRepositoryImpl;", "Lcom/kareem/domain/repositories/products/ProductsRepository;", "service", "Lcom/kareem/data/remote/ApiInterface;", "(Lcom/kareem/data/remote/ApiInterface;)V", "getProductsList", "Lcom/kareem/domain/models/entities/products/ProductsListResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ProductsRepositoryImpl implements com.kareem.domain.repositories.products.ProductsRepository {
    private final com.kareem.data.remote.ApiInterface service = null;
    
    @javax.inject.Inject()
    public ProductsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kareem.data.remote.ApiInterface service) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getProductsList(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kareem.domain.models.entities.products.ProductsListResponse> continuation) {
        return null;
    }
}