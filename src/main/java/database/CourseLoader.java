package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CourseLoader {

  public Course getCourseWithInput(int id) {
    EntityManager em = new DbConfigurator().getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Course> courses = em.createQuery("SELECT v FROM course v WHERE id = " + id, Course.class)
        .getResultList();
    return courses.get(0);
  }

  public static void main(String[] args) {
    CourseLoader cl = new CourseLoader();
    Course c = cl.getCourseWithInput(1);

    System.out.println(c.getVideos());
  }
}
