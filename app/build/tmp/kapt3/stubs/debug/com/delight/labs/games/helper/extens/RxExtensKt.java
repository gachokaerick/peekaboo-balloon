package com.delight.labs.games.helper.extens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\f\u00a2\u0006\u0002\u0010\r\u001a1\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000f\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u0002\u00a2\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017\u00a8\u0006\u0018"}, d2 = {"async", "Lio/reactivex/Flowable;", "T", "withDelay", "", "Lio/reactivex/Single;", "bindLifeCycle", "Lcom/uber/autodispose/SingleSubscribeProxy;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "get", "", "Landroidx/lifecycle/MutableLiveData;", "(Landroidx/lifecycle/MutableLiveData;)Ljava/lang/Object;", "init", "Landroidx/lifecycle/MediatorLiveData;", "t", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)Landroidx/lifecycle/MediatorLiveData;", "set", "", "value", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "toFlowable", "Landroidx/lifecycle/LiveData;", "app_debug"})
public final class RxExtensKt {
    
    /**
     * * 页面描述：RxjavaExtens
     * *
     * * Created by ditclear on 2018/12/11.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Flowable<T> async(@org.jetbrains.annotations.NotNull()
    io.reactivex.Flowable<T> $receiver, long withDelay) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Single<T> async(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<T> $receiver, long withDelay) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.uber.autodispose.SingleSubscribeProxy<T> bindLifeCycle(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<T> $receiver, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Flowable<T> toFlowable(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<T> $receiver) {
        return null;
    }
    
    public static final <T extends java.lang.Object>void set(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<T> $receiver, @org.jetbrains.annotations.Nullable()
    T value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>T get(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<T> $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>androidx.lifecycle.MediatorLiveData<T> init(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<T> $receiver, @org.jetbrains.annotations.Nullable()
    T t) {
        return null;
    }
}