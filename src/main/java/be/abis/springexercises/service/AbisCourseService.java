package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.CourseNotFoundException;
import be.abis.springexercises.model.Course;
import be.abis.springexercises.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("abis")
public class AbisCourseService implements CourseService{


    //private CourseRepository cr;
    @Autowired CourseRepository cr;
    private List<String> coursesCheaperThan500 = new ArrayList<>();

    //different way to inject
    /*
    @Autowired
    public AbisCourseService(CourseRepository cr){
        this.cr = cr;
    }

     */

    @Override
    public List<Course> findAllCourses() {
        return cr.findAllCourses();
    }

    public CourseRepository getCr() {
        return cr;
    }

    public void setCr(CourseRepository cr) {
        this.cr = cr;
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


    @Value("#{memoryCourseRepository.courses.?[pricePerDay lt 500.0].![shortTitle]}")
    public void setCoursesCheaperThan500(List<String>namesOfCheaperCourses){
        this.coursesCheaperThan500 = namesOfCheaperCourses;
    }

    public List<String> getCoursesCheaperThan500(){
        return coursesCheaperThan500;
    }



}
