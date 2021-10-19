package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class VideoLoader {

  // Problem 1: write a method that returns a Video record from DB where video id = 2
  public Video getVideoWithId2() {
    EntityManager em = new DbConfigurator().getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Video> videos = em.createQuery("SELECT v FROM video v WHERE id = 2", Video.class).getResultList();
    return videos.get(0);
  }

  // Problem 2: write a method that returns a video record from DB for any given id provided by the method caller
  public Video getVideoWithInput(int id){
    EntityManager em = new DbConfigurator().getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Video> videos = em.createQuery("SELECT v FROM video v WHERE id = "+ id, Video.class).getResultList();
    return videos.get(0);
  }


  // Problem 3:
  // 1. create a new table called course (id, title, author)
  // 2. insert 1 record  (1, "Learn Tech", "Qi Wei")
  // 3. write a method that returns this course


  public static void main(String[] args) {
    VideoLoader vl = new VideoLoader();
    System.out.println(vl.getVideoWithInput(1));

  }
}
