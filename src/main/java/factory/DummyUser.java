package factory;

public class DummyUser {

  public void useDummyObj() {
    Dummy d = new DummyFactory().getDummy();

    // use this d.....
  }
}
