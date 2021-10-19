package annotation;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class MyList<T> {

  List<T> container;

  public List<Class<?>> getClassesForAllElements() {
    return ImmutableList.of();
  }
}
