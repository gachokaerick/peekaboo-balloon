package com.delight.labs.games.helper.network;

import java.lang.System;

/**
 * * 页面描述：网络配置
 * *
 * *
 * * Created by ditclear on 2017/7/28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0015\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&\u00a8\u0006\u0014"}, d2 = {"Lcom/delight/labs/games/helper/network/NetProvider;", "", "configConnectTimeoutSecs", "", "configCookie", "Lokhttp3/CookieJar;", "configHandler", "Lcom/delight/labs/games/helper/network/RequestHandler;", "configHttps", "", "builder", "Lokhttp3/OkHttpClient$Builder;", "configInterceptors", "", "Lokhttp3/Interceptor;", "()[Lokhttp3/Interceptor;", "configLogEnable", "", "configReadTimeoutSecs", "configWriteTimeoutSecs", "app_debug"})
public abstract interface NetProvider {
    
    @org.jetbrains.annotations.Nullable()
    public abstract okhttp3.Interceptor[] configInterceptors();
    
    public abstract void configHttps(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient.Builder builder);
    
    @org.jetbrains.annotations.Nullable()
    public abstract okhttp3.CookieJar configCookie();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.delight.labs.games.helper.network.RequestHandler configHandler();
    
    public abstract long configConnectTimeoutSecs();
    
    public abstract long configReadTimeoutSecs();
    
    public abstract long configWriteTimeoutSecs();
    
    public abstract boolean configLogEnable();
}