package jpa.entitymodels;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NamedQuery(query = "Select s from Student s", name = "allStudents")


public class Student {

    //Student’s current school email, unique student identifier
        @Id
        @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(50)")
        String sEmail;

 //The full name of the student
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)")
    String sName;

    //Student’s password in order to log in
    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(50)")
    String sPass;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_email", referencedColumnName = "email",unique = false)},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id",unique = false)},
            indexes = {@Index(columnList = "student_email,course_id")}
    )
    List<Course> sCourses;

    //constructor takes no parameters and it initializes every member to an initial value
    public Student() {
        this.sEmail = "";
        this.sName = "";
        this.sPass = "";
    }
    //constructor initializes every private member with a parameter provided to the constructor
    public Student(String sEmail, String sName, String sPass) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student student = (Student) obj;
        return sEmail.equals(student.sEmail) && sName.equals(student.sName) && sPass.equals(student.sPass);
    }
}
