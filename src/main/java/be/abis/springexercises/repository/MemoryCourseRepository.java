package be.abis.springexercises.repository;



import be.abis.springexercises.exceptions.CourseNotFoundException;
import be.abis.springexercises.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MemoryCourseRepository implements CourseRepository {
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	
	public MemoryCourseRepository(){
		courses.add(new Course("7850","DB2, an overview","DB2, an overview",5,550.0));
		courses.add(new Course("7900","Workshop SQL","Workshop SQL",3,475.0));
		courses.add(new Course("8000","Java Prog","Java Programming",5,500.0));
		courses.add(new Course("8050","Maven","Maven",1,450.0));
		courses.add(new Course("8100","Spring","Programming with Spring",3,525.0));
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	
	@Override
	public List<Course> findAllCourses() {
		return courses;
	}

	@Override
	public Course findCourse(int id) {
		return courses.stream().filter(c->c.getCourseId().equals(id+"")).findFirst().orElse(null);
	}

	@Override
	public Course findCourse(String shortTitle) {
		return courses.stream().filter(c->c.getShortTitle().equals(shortTitle)).findFirst().orElse(null);
	}

	public void addCourse(Course c){
		courses.add(c);
	}

	public void updateCourse(Course c) throws CourseNotFoundException{
		Course found = findCourse(c.getCourseId());
		if (found == null){throw new CourseNotFoundException("Course not found");}
		found.setLongTitle(c.getLongTitle());
		found.setNumberOfDays(c.getNumberOfDays());
		found.setPricePerDay(c.getPricePerDay());
		found.setShortTitle(c.getShortTitle());
	}

	public void deleteCourse(Course c) throws CourseNotFoundException {
		if (findCourse(c.getCourseId())==null) {throw new CourseNotFoundException("Course does not exist"); }
		courses.remove(c);
	}


}
