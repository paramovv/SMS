package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import java.util.List;

public interface StudentDAO {
//method declaration
    List<Student> getAllStudents();
    Student getStudentByEmail(String sEmail);
    boolean validateStudent(String sEmail, String sPassword);
    void registerStudentToCourse(String sEmail, int cID);
    List<Course>  getStudentCourses(String sEmail);
}
