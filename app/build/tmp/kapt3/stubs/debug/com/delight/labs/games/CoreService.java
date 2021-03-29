package com.delight.labs.games;

import java.lang.System;

/**
 * * 页面描述：CoreService spi 加载
 * *
 * * Created by ditclear on 2018/11/28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/delight/labs/games/CoreService;", "", "serviceName", "", "getServiceName", "()Ljava/lang/String;", "init", "", "app", "Landroid/app/Application;", "app_debug"})
public abstract interface CoreService {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getServiceName();
    
    public abstract void init(@org.jetbrains.annotations.NotNull()
    android.app.Application app);
}