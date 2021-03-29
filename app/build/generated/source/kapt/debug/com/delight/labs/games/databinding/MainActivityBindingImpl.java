package com.delight.labs.games.databinding;
import com.delight.labs.games.R;
import com.delight.labs.games.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MainActivityBindingImpl extends MainActivityBinding  {

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
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener doubleEtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.doubleBindText.getValue()
            //         is vm.doubleBindText.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(doubleEt);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            com.delight.labs.games.view.main.viewmodel.MainViewModel vm = mVm;
            // vm.doubleBindText
            androidx.lifecycle.MutableLiveData<java.lang.String> vmDoubleBindText = null;
            // vm.doubleBindText.getValue()
            java.lang.String vmDoubleBindTextGetValue = null;
            // vm.doubleBindText != null
            boolean vmDoubleBindTextJavaLangObjectNull = false;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmDoubleBindText = vm.getDoubleBindText();

                vmDoubleBindTextJavaLangObjectNull = (vmDoubleBindText) != (null);
                if (vmDoubleBindTextJavaLangObjectNull) {




                    vmDoubleBindText.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public MainActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private MainActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.doubleEt.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.testTv.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.vm == variableId) {
            setVm((com.delight.labs.games.view.main.viewmodel.MainViewModel) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.delight.labs.games.view.base.Presenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.delight.labs.games.view.main.viewmodel.MainViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setPresenter(@Nullable com.delight.labs.games.view.base.Presenter Presenter) {
        this.mPresenter = Presenter;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmDoubleBindText((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeVmText((androidx.lifecycle.MediatorLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmDoubleBindText(androidx.lifecycle.MutableLiveData<java.lang.String> VmDoubleBindText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmText(androidx.lifecycle.MediatorLiveData<java.lang.String> VmText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        androidx.lifecycle.MutableLiveData<java.lang.String> vmDoubleBindText = null;
        com.delight.labs.games.view.main.viewmodel.MainViewModel vm = mVm;
        java.lang.String vmDoubleBindTextGetValue = null;
        java.lang.String vmTextGetValue = null;
        androidx.lifecycle.MediatorLiveData<java.lang.String> vmText = null;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (vm != null) {
                        // read vm.doubleBindText
                        vmDoubleBindText = vm.getDoubleBindText();
                    }
                    updateLiveDataRegistration(0, vmDoubleBindText);


                    if (vmDoubleBindText != null) {
                        // read vm.doubleBindText.getValue()
                        vmDoubleBindTextGetValue = vmDoubleBindText.getValue();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (vm != null) {
                        // read vm.text
                        vmText = vm.getText();
                    }
                    updateLiveDataRegistration(1, vmText);


                    if (vmText != null) {
                        // read vm.text.getValue()
                        vmTextGetValue = vmText.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doubleEt, vmDoubleBindTextGetValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, vmDoubleBindTextGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.doubleEt, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, doubleEtandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.testTv, vmTextGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.doubleBindText
        flag 1 (0x2L): vm.text
        flag 2 (0x3L): vm
        flag 3 (0x4L): presenter
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}