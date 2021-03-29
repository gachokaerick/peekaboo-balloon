package com.delight.labs.games.helper.network;

import java.lang.System;

/**
 * * 页面描述：网络拦截
 * *
 * *
 * * Created by ditclear on 2017/7/28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/delight/labs/games/helper/network/RequestHandler;", "", "onAfterRequest", "Lokhttp3/Response;", "response", "chain", "Lokhttp3/Interceptor$Chain;", "onBeforeRequest", "Lokhttp3/Request;", "request", "app_debug"})
public abstract interface RequestHandler {
    
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.Request onBeforeRequest(@org.jetbrains.annotations.NotNull()
    okhttp3.Request request, @org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain);
    
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.Response onAfterRequest(@org.jetbrains.annotations.NotNull()
    okhttp3.Response response, @org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) throws java.io.IOException;
}