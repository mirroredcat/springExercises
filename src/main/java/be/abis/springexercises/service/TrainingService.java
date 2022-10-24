package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.EnrollException;
import be.abis.springexercises.model.Course;
import be.abis.springexercises.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    public String getWelcomeMessage();
    public List<Course> showFollowedCourses(Person p);
    public String enrollForSession(Person p, Course c, LocalDate date) throws EnrollException;
    public PersonService getPs();
    public CourseService getCs();
}
