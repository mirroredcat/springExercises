package be.abis.springexercises.repository;



import be.abis.springexercises.exceptions.CourseNotFoundException;
import be.abis.springexercises.model.Course;

import java.util.List;


public interface CourseRepository {

	public List<Course> findAllCourses();
	public Course findCourse(int id);
	public Course findCourse(String shortTitle);
	public void addCourse(Course c);
	public void updateCourse(Course c)throws CourseNotFoundException;
	public void deleteCourse(Course c) throws CourseNotFoundException;
}
