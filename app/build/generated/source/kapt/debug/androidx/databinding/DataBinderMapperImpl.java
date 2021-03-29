package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.delight.labs.games.DataBinderMapperImpl());
    addMapper(new V1CompatDataBinderMapperImpl());
  }
}
