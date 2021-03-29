package com.delight.labs.games.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;

public abstract class FragmentWelcomeBinding extends ViewDataBinding {
  @NonNull
  public final MaterialCardView cvFloating;

  @NonNull
  public final MaterialCardView cvPeekaboo;

  protected FragmentWelcomeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, MaterialCardView cvFloating, MaterialCardView cvPeekaboo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvFloating = cvFloating;
    this.cvPeekaboo = cvPeekaboo;
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWelcomeBinding>inflate(inflater, com.delight.labs.games.R.layout.fragment_welcome, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWelcomeBinding>inflate(inflater, com.delight.labs.games.R.layout.fragment_welcome, null, false, component);
  }

  public static FragmentWelcomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWelcomeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWelcomeBinding)bind(component, view, com.delight.labs.games.R.layout.fragment_welcome);
  }
}
