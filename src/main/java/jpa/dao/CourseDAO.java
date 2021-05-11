package jpa.dao;

import jpa.entitymodels.Course;
import java.util.List;

public interface CourseDAO {
   //method declaration
    List<Course> getAllCourses();
    Course getCourseById(int id);

}
