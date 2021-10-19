package reflection;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Reflection {

  public static void main(String[] args) throws Exception {
    Class<?> reflectionClass = Reflection.class;

    Annotation[] annotations = reflectionClass.getAnnotations();
    for (Annotation a: annotations) {
      System.out.println(a);
    }

//    List<Integer> list = getList(1, 3, 3, 4, 5, 5);

  }

  public Object createObject(Class<?> aClass) throws Exception{
    Constructor c= aClass.getConstructor();
    return c.newInstance();
  }


  public static List<Integer> getList(Integer... integers) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < integers.length; i++) {
      list.add(i);
    }
    return list;
  }
}

class Animal {
  public static void main(String[] args) throws Exception{
    Animal a = (Animal) new Reflection().createObject(Animal.class);
  }
}
