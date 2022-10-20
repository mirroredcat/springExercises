package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.CourseNotFoundException;
import be.abis.springexercises.model.Course;
import be.abis.springexercises.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AbisCourseService implements CourseService{


    private CourseRepository cr;

    //different way to inject
    @Autowired
    public AbisCourseService(CourseRepository crp){
        this.cr = crp;
    }

    @Override
    public List<Course> findAllCourses() {
        return cr.findAllCourses();
    }

    @Override
    public Course findCourse(int id) {
        return cr.findCourse(id);
    }

    @Override
    public Course findCourse(String shortTitle) {
        return cr.findCourse(shortTitle);
    }

    @Override
    public void addCourse(Course c) {
        cr.addCourse(c);
    }

    @Override
    public void updateCourse(Course c) throws CourseNotFoundException {
        cr.updateCourse(c);
    }

    @Override
    public void deleteCourse(Course c) throws CourseNotFoundException {
        cr.deleteCourse(c);
    }
}
