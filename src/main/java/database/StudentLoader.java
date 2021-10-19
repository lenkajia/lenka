package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentLoader {

    public Student getStudentWithInput(int id){
      EntityManager em = new DbConfigurator().getEntityManager();
      EntityTransaction tx = em.getTransaction();
      tx.begin();
      List<Student>students = em.createQuery("SELECT s FROM student s WHERE id = " + id, Student.class)
          .getResultList();
      return students.get(0);
    }

    public static void main (String[] args){
      StudentLoader s1 = new StudentLoader();
      Student s = s1.getStudentWithInput(2);

      System.out.println(s.getCourses());
    }
}
