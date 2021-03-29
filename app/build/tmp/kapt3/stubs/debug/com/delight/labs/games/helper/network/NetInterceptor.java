package com.delight.labs.games.helper.network;

import java.lang.System;

/**
 * * 页面描述：默认拦截器
 * *
 * *
 * * Created by ditclear on 2017/7/28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/delight/labs/games/helper/network/NetInterceptor;", "Lokhttp3/Interceptor;", "handler", "Lcom/delight/labs/games/helper/network/RequestHandler;", "(Lcom/delight/labs/games/helper/network/RequestHandler;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
public final class NetInterceptor implements okhttp3.Interceptor {
    private final com.delight.labs.games.helper.network.RequestHandler handler = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        return null;
    }
    
    public NetInterceptor(@org.jetbrains.annotations.Nullable()
    com.delight.labs.games.helper.network.RequestHandler handler) {
        super();
    }
}