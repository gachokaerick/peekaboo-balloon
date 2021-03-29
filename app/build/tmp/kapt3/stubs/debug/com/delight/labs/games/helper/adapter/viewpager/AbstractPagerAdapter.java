package com.delight.labs.games.helper.adapter.viewpager;

import java.lang.System;

/**
 * * 页面描述：fragment PagerAdapter
 * *
 * * Created by ditclear on 2017/9/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/delight/labs/games/helper/adapter/viewpager/AbstractPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "title", "", "", "(Landroidx/fragment/app/FragmentManager;[Ljava/lang/String;)V", "list", "", "Landroidx/fragment/app/Fragment;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getTitle", "()[Ljava/lang/String;", "setTitle", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getCount", "", "getItem", "pos", "getPageTitle", "", "position", "app_debug"})
public abstract class AbstractPagerAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<androidx.fragment.app.Fragment> list;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] title;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.fragment.app.Fragment> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.fragment.app.Fragment> p0) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public abstract androidx.fragment.app.Fragment getItem(int pos);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.CharSequence getPageTitle(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    public AbstractPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    java.lang.String[] title) {
        super(null);
    }
}