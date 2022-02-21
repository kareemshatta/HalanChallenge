package com.kareem.data.remote.dto_models.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0000H\u0016J\t\u0010\u001b\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/kareem/data/remote/dto_models/auth/LoginResponseDTO;", "Lcom/kareem/domain/mapper/Mapper;", "Lcom/kareem/domain/models/entities/LoginResponse;", "token", "", "profile", "Lcom/kareem/data/remote/dto_models/auth/ProfileDTO;", "(Ljava/lang/String;Lcom/kareem/data/remote/dto_models/auth/ProfileDTO;)V", "getProfile", "()Lcom/kareem/data/remote/dto_models/auth/ProfileDTO;", "setProfile", "(Lcom/kareem/data/remote/dto_models/auth/ProfileDTO;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "map", "from", "toString", "data_debug"})
public final class LoginResponseDTO implements com.kareem.domain.mapper.Mapper<com.kareem.data.remote.dto_models.auth.LoginResponseDTO, com.kareem.domain.models.entities.LoginResponse> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    private com.kareem.data.remote.dto_models.auth.ProfileDTO profile;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kareem.data.remote.dto_models.auth.LoginResponseDTO copy(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    com.kareem.data.remote.dto_models.auth.ProfileDTO profile) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public LoginResponseDTO(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    com.kareem.data.remote.dto_models.auth.ProfileDTO profile) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kareem.data.remote.dto_models.auth.ProfileDTO component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kareem.data.remote.dto_models.auth.ProfileDTO getProfile() {
        return null;
    }
    
    public final void setProfile(@org.jetbrains.annotations.NotNull()
    com.kareem.data.remote.dto_models.auth.ProfileDTO p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kareem.domain.models.entities.LoginResponse map(@org.jetbrains.annotations.NotNull()
    com.kareem.data.remote.dto_models.auth.LoginResponseDTO from) {
        return null;
    }
}