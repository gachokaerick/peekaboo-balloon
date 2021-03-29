package com.delight.labs.games.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.delight.labs.games.view.base.Presenter;

public abstract class CoreLayoutHolderBinding extends ViewDataBinding {
  @Bindable
  protected Presenter mPresenter;

  protected CoreLayoutHolderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setPresenter(@Nullable Presenter presenter);

  @Nullable
  public Presenter getPresenter() {
    return mPresenter;
  }

  @NonNull
  public static CoreLayoutHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CoreLayoutHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CoreLayoutHolderBinding>inflate(inflater, com.delight.labs.games.R.layout.core_layout_holder, root, attachToRoot, component);
  }

  @NonNull
  public static CoreLayoutHolderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CoreLayoutHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CoreLayoutHolderBinding>inflate(inflater, com.delight.labs.games.R.layout.core_layout_holder, null, false, component);
  }

  public static CoreLayoutHolderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static CoreLayoutHolderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (CoreLayoutHolderBinding)bind(component, view, com.delight.labs.games.R.layout.core_layout_holder);
  }
}
