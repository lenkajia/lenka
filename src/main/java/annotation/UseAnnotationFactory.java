package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UseAnnotationFactory {

  // return an object of UseAnnotation
  // In the return UseAnnotation object, all member fields that are annotated by @MyAnnotation
  // must be intialized.
  public UseAnnotation getInstance() {
    UseAnnotation ua = new UseAnnotation();
    List<Field> annotatedField = getTargetFields();

    // initialize all field in annotatedField



    return ua;
  }

  public List<Field> getTargetFields() {
    Class<?> clazz = UseAnnotation.class;
    Field[] fields = clazz.getDeclaredFields();
    List<Field> annotatedFields = new ArrayList<>();

    // 1. if a field of this class has any annotation, add it in the annotatedFields
    for (Field f : fields) {
      if (f.getDeclaredAnnotations().length > 0) {
        Annotation[] annotations = f.getDeclaredAnnotations();
        if (contains(annotations, MyAnnotation.class)) {
          annotatedFields.add(f);
        }
      }
    }

    return annotatedFields;
  }

  public boolean contains(Annotation[] annotations, Class<?> annotationClass) {
    for (int i = 0; i < annotations.length; i++) {
      if (annotations[i].toString().contains(annotationClass.getName())) {
        return true;
      }
    }
    return false;
  }
}
