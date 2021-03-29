package io.ditclear.bindingadapter.databinding;
import io.ditclear.bindingadapter.R;
import io.ditclear.bindingadapter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutHolderBinding extends androidx.databinding.ViewDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView0;
    // variables
    @Nullable
    private java.lang.Object mItem;
    @Nullable
    private java.lang.String mPresenter;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutHolderBinding(@NonNull androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.TextView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((java.lang.Object) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable java.lang.Object Item) {
        this.mItem = Item;
    }
    @Nullable
    public java.lang.Object getItem() {
        return mItem;
    }
    public void setPresenter(@Nullable java.lang.String Presenter) {
        this.mPresenter = Presenter;
    }
    @Nullable
    public java.lang.String getPresenter() {
        return mPresenter;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static LayoutHolderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LayoutHolderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        return androidx.databinding.DataBindingUtil.<LayoutHolderBinding>inflate(inflater, io.ditclear.bindingadapter.R.layout.layout_holder, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static LayoutHolderBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LayoutHolderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.ditclear.bindingadapter.R.layout.layout_holder, null, false), bindingComponent);
    }
    @NonNull
    public static LayoutHolderBinding bind(@NonNull android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LayoutHolderBinding bind(@NonNull android.view.View view, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/layout_holder_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new LayoutHolderBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): presenter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}