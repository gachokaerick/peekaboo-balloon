package com.delight.labs.games.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.delight.labs.games.view.base.Presenter;
import com.delight.labs.games.view.main.viewmodel.MainViewModel;

public abstract class MainActivityBinding extends ViewDataBinding {
  @NonNull
  public final EditText doubleEt;

  @NonNull
  public final TextView testTv;

  @Bindable
  protected MainViewModel mVm;

  @Bindable
  protected Presenter mPresenter;

  protected MainActivityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText doubleEt, TextView testTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.doubleEt = doubleEt;
    this.testTv = testTv;
  }

  public abstract void setVm(@Nullable MainViewModel vm);

  @Nullable
  public MainViewModel getVm() {
    return mVm;
  }

  public abstract void setPresenter(@Nullable Presenter presenter);

  @Nullable
  public Presenter getPresenter() {
    return mPresenter;
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MainActivityBinding>inflate(inflater, com.delight.labs.games.R.layout.main_activity, root, attachToRoot, component);
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MainActivityBinding>inflate(inflater, com.delight.labs.games.R.layout.main_activity, null, false, component);
  }

  public static MainActivityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static MainActivityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (MainActivityBinding)bind(component, view, com.delight.labs.games.R.layout.main_activity);
  }
}
