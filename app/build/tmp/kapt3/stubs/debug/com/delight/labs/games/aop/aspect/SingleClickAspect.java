package com.delight.labs.games.aop.aspect;

import java.lang.System;

/**
 * * Created by baixiaokang on 16/12/9.
 * * {link https://github.com/north2016/T-MVP/blob/master/app/src/main/java/com/aop/SingleClickAspect.java}
 * * 防止View被连续点击,间隔时间600ms
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/delight/labs/games/aop/aspect/SingleClickAspect;", "", "()V", "aroundJoinPoint", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "methodAnnotated", "Companion", "app_debug"})
@org.aspectj.lang.annotation.Aspect()
public final class SingleClickAspect {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SingleClickAspect";
    private static final int MIN_CLICK_DELAY_TIME = 600;
    private static int TIME_TAG;
    public static final com.delight.labs.games.aop.aspect.SingleClickAspect.Companion Companion = null;
    
    @org.aspectj.lang.annotation.Pointcut(value = "execution(@com.delight.labs.games.aop.annotation.SingleClick * *(..))")
    public final void methodAnnotated() {
    }
    
    @org.aspectj.lang.annotation.Around(value = "methodAnnotated()")
    public final void aroundJoinPoint(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.ProceedingJoinPoint joinPoint) throws java.lang.Throwable {
    }
    
    public SingleClickAspect() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/delight/labs/games/aop/aspect/SingleClickAspect$Companion;", "", "()V", "MIN_CLICK_DELAY_TIME", "", "getMIN_CLICK_DELAY_TIME", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "TIME_TAG", "getTIME_TAG$app_debug", "setTIME_TAG$app_debug", "(I)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        public final int getMIN_CLICK_DELAY_TIME() {
            return 0;
        }
        
        public final int getTIME_TAG$app_debug() {
            return 0;
        }
        
        public final void setTIME_TAG$app_debug(int p0) {
        }
        
        private Companion() {
            super();
        }
    }
}