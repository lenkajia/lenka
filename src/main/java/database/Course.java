package database;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "course")
@Entity(name = "course")
@Data
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  private List<Video> videos;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  public String toString() {
    return "[course id: " + id + "; course title: " + title + "; course author: " + author + "]";
  }
}
