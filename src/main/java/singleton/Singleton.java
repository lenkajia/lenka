package singleton;

// Lazy / eager singleton
public class Singleton {

  // What is the visibility of a volatile variable
  private static volatile Singleton instance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }

    return instance;
  }
}
