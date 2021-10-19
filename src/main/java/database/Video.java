package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "video")
@Entity(name = "video")
@Data
public class Video {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @Column(name = "description")
  private String desc;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  public String toString() {
    return "[video Id: " + id + "; video title: " + title + "; video author: " + author + "]";
  }
}
