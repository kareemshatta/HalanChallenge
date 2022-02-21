package com.kareem.domain.repositories.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/kareem/domain/repositories/auth/AuthRepository;", "", "login", "Lcom/kareem/domain/models/entities/LoginResponse;", "loginInput", "Lcom/kareem/domain/models/inputs/LoginInput;", "(Lcom/kareem/domain/models/inputs/LoginInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.kareem.domain.models.inputs.LoginInput loginInput, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kareem.domain.models.entities.LoginResponse> continuation);
}