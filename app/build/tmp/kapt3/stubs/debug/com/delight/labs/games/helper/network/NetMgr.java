package com.delight.labs.games.helper.network;

import java.lang.System;

/**
 * * 页面描述：网络管理类
 * *
 * *
 * * Created by ditclear on 2017/7/28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\u001a\u001a\u00020\u0018J\u001d\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002\u00a2\u0006\u0002\u0010 J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002J*\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010!\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0086\u0002\u00a2\u0006\u0002\u0010&J\u0018\u0010\'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060)J\u001c\u0010*\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160)J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u0016\u0010,\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u000fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/delight/labs/games/helper/network/NetMgr;", "", "()V", "clientMap", "Ljava/util/HashMap;", "", "Lokhttp3/OkHttpClient;", "<set-?>", "Lcom/delight/labs/games/helper/network/NetProvider;", "commonProvider", "getCommonProvider", "()Lcom/delight/labs/games/helper/network/NetProvider;", "setCommonProvider", "(Lcom/delight/labs/games/helper/network/NetProvider;)V", "connectTimeoutMills", "", "getConnectTimeoutMills", "()J", "providerMap", "readTimeoutMills", "getReadTimeoutMills", "retrofitMap", "Lretrofit2/Retrofit;", "checkProvider", "", "provider", "clearCache", "empty", "", "interceptors", "", "Lokhttp3/Interceptor;", "([Lokhttp3/Interceptor;)Z", "baseUrl", "get", "S", "service", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getClient", "getClientMap", "", "getRetrofit", "getRetrofitMap", "registerProvider", "app_debug"})
public final class NetMgr {
    private static final java.util.HashMap<java.lang.String, com.delight.labs.games.helper.network.NetProvider> providerMap = null;
    private static final java.util.HashMap<java.lang.String, retrofit2.Retrofit> retrofitMap = null;
    private static final java.util.HashMap<java.lang.String, okhttp3.OkHttpClient> clientMap = null;
    private static final long connectTimeoutMills = 10000L;
    private static final long readTimeoutMills = 10000L;
    @org.jetbrains.annotations.Nullable()
    private static com.delight.labs.games.helper.network.NetProvider commonProvider;
    public static final com.delight.labs.games.helper.network.NetMgr INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.Nullable()
    com.delight.labs.games.helper.network.NetProvider provider) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
        return null;
    }
    
    private final boolean empty(java.lang.String baseUrl) {
        return false;
    }
    
    private final okhttp3.OkHttpClient getClient(java.lang.String baseUrl, com.delight.labs.games.helper.network.NetProvider provider) {
        return null;
    }
    
    private final boolean empty(okhttp3.Interceptor[] interceptors) {
        return false;
    }
    
    private final void checkProvider(com.delight.labs.games.helper.network.NetProvider provider) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, retrofit2.Retrofit> getRetrofitMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, okhttp3.OkHttpClient> getClientMap() {
        return null;
    }
    
    public final long getConnectTimeoutMills() {
        return 0L;
    }
    
    public final long getReadTimeoutMills() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.delight.labs.games.helper.network.NetProvider getCommonProvider() {
        return null;
    }
    
    private final void setCommonProvider(com.delight.labs.games.helper.network.NetProvider p0) {
    }
    
    public final <S extends java.lang.Object>S get(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    java.lang.Class<S> service) {
        return null;
    }
    
    public final void registerProvider(@org.jetbrains.annotations.NotNull()
    com.delight.labs.games.helper.network.NetProvider provider) {
    }
    
    public final void registerProvider(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    com.delight.labs.games.helper.network.NetProvider provider) {
    }
    
    public final void clearCache() {
    }
    
    private NetMgr() {
        super();
    }
}