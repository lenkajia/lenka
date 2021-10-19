package database;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "student")
@Entity(name = "student")
@Data
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @OneToMany(mappedBy = "student")
  private List<Course> courses;

  public String toString(){
    return"[student id: " + id +"; student firstName: " + firstName + "; student lastName: " + lastName + "]";
  }

}
