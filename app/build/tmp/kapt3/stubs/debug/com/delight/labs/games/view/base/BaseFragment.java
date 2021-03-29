package com.delight.labs.games.view.base;

import java.lang.System;

/**
 * * 页面描述：fragment 基类
 * *
 * * Created by ditclear on 2017/9/27.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H&J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020#H&J\b\u0010\u000e\u001a\u00020#H\u0016J\u0010\u0010\'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0007H&J\u0012\u0010)\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u00103\u001a\u00020#H\u0004J\b\u00104\u001a\u00020#H\u0014J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0011\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000b\u00a8\u00067"}, d2 = {"Lcom/delight/labs/games/view/base/BaseFragment;", "VB", "Landroid/databinding/ViewDataBinding;", "Landroid/support/v4/app/Fragment;", "Lcom/delight/labs/games/view/base/Presenter;", "()V", "hasLoadOnce", "", "getHasLoadOnce", "()Z", "setHasLoadOnce", "(Z)V", "isPrepared", "setPrepared", "lazyLoad", "getLazyLoad", "setLazyLoad", "mBinding", "getMBinding", "()Landroid/databinding/ViewDataBinding;", "setMBinding", "(Landroid/databinding/ViewDataBinding;)V", "Landroid/databinding/ViewDataBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "visible", "getVisible", "setVisible", "getLayoutId", "", "initArgs", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "loadData", "isRefresh", "onActivityCreated", "onClick", "v", "Landroid/view/View;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onInvisible", "onVisible", "setUserVisibleHint", "isVisibleToUser", "app_debug"})
public abstract class BaseFragment<VB extends android.databinding.ViewDataBinding> extends android.support.v4.app.Fragment implements com.delight.labs.games.view.base.Presenter {
    @org.jetbrains.annotations.NotNull()
    protected VB mBinding;
    @org.jetbrains.annotations.NotNull()
    protected android.content.Context mContext;
    private boolean lazyLoad;
    private boolean visible;
    
    /**
     * * 标志位，标志已经初始化完成
     */
    private boolean isPrepared;
    
    /**
     * * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean hasLoadOnce;
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getMBinding() {
        return null;
    }
    
    protected final void setMBinding(@org.jetbrains.annotations.NotNull()
    VB p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    protected final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    protected final boolean getLazyLoad() {
        return false;
    }
    
    protected final void setLazyLoad(boolean p0) {
    }
    
    protected final boolean getVisible() {
        return false;
    }
    
    protected final void setVisible(boolean p0) {
    }
    
    protected final boolean isPrepared() {
        return false;
    }
    
    protected final void setPrepared(boolean p0) {
    }
    
    protected final boolean getHasLoadOnce() {
        return false;
    }
    
    protected final void setHasLoadOnce(boolean p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * * 是否可见，延迟加载
     */
    @java.lang.Override()
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }
    
    protected final void onInvisible() {
    }
    
    protected void onVisible() {
    }
    
    public void lazyLoad() {
    }
    
    public void initArgs(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract void initView();
    
    public abstract void loadData(boolean isRefresh);
    
    public abstract int getLayoutId();
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    public BaseFragment() {
        super();
    }
}