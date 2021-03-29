
package android.databinding;
import com.delight.labs.games.BR;
import android.util.SparseArray;
class V1CompatDataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public V1CompatDataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case io.ditclear.bindingadapter.R.layout.layout_holder:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/layout_holder_0".equals(tag)) {
                            return new io.ditclear.bindingadapter.databinding.LayoutHolderBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for layout_holder is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 808871661: {
                if(tag.equals("layout/layout_holder_0")) {
                    return io.ditclear.bindingadapter.R.layout.layout_holder;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        final String value = InnerBrLookup.sKeys.get(id);
        return value;
    }
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>();
        static {
                sKeys.put(0, "_all");
                sKeys.put(0, "_all");
                sKeys.put(1, "item");
                sKeys.put(2, "presenter");
                sKeys.put(3, "vm");
        }
    }
}