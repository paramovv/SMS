package jpa.entitymodels;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Course")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NamedQuery(query = "Select c from Course c", name = "allCourses")

public class Course {

//Unique Course Identifier
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11) UNSIGNED")
    int cID;

//Provides the name of the course
    @Column(name = "name", nullable = false, columnDefinition= "VARCHAR(50)")
     String cName;

   // Provides the name of the instructor
    @Column(name = "instructor", nullable = false, columnDefinition= "VARCHAR(50)")
    String cInstructorName;

//constructor takes no parameters and it initializes every member to an initial value
    public Course() {
        this.cName = "";
        this.cInstructorName = "";
    }
//constructor initializes every private member with a parameter provided to the constructor.
    public Course(String cName, String cInstructorName) {
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course course = (Course) obj;
        return cID == course.cID && Objects.equals(cName, course.cName) && Objects.equals(cInstructorName, course.cInstructorName);
    }
}
