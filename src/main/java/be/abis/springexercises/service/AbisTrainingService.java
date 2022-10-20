package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.EnrollException;
import be.abis.springexercises.model.Course;
import be.abis.springexercises.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;


public class AbisTrainingService  implements TrainingService{


    private PersonService ps;
    private CourseService cs;


    public void setPs(PersonService ps) {
        this.ps = ps;
    }

    public void setCs(CourseService cs) {
        this.cs = cs;
    }

    @PostConstruct
    public void init(){
        System.out.println("AbisTrainingService is ready for work");
    }

    @Value("${greeting.message}")
    public String getWelcomeMessage;

    @Override
    public String getWelcomeMessage() {
        return getWelcomeMessage;
    }

    @Override
    public List<Course> showFollowedCourses(Person p) {
        return null;
    }

    @Override
    public void enrollForSession(Person p, Course c, LocalDate date) throws EnrollException {

    }
}
