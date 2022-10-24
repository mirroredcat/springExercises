package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.CourseNotFoundException;
import be.abis.springexercises.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("someCourseService")
public class SomeCourseService implements CourseService{


    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public Course findCourse(int id) {
        if (id == 7900){
            return 	(new Course("7900", "Test Course", "TestCourse", 1, 100.0));
        }
        return null;
    }

    @Override
    public Course findCourse(String shortTitle) {
        return null;
    }

    @Override
    public void addCourse(Course c) {

    }

    @Override
    public void updateCourse(Course c) throws CourseNotFoundException {

    }

    @Override
    public void deleteCourse(Course c) throws CourseNotFoundException {

    }

    @Override
    public List<String> getCoursesCheaperThan500() {
        return null;
    }
}
