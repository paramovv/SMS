package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class CourseService implements CourseDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMS");


    //This method takes no parameter and returns every Course in the table
    @Override
    @Transactional
    public List<Course> getAllCourses() {
        List<Course> courses = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // creates allCourses query
            Query query = entityManager.createNamedQuery("allCourses");
            courses = query.getResultList();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
        return courses;
    }

    @Transactional
    public Course getCourseById(int cId) {
        Course course = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            course = entityManager.find(Course.class, cId);
        } catch (Exception e) {
                } finally {
            entityManager.close();
        }
        return course;
    }
}

