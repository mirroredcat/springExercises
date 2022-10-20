package be.abis.springexercises;

import be.abis.springexercises.model.Course;
import be.abis.springexercises.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringExercisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExercisesApplication.class, args);
    }

    @Bean
    public TrainingService trainingService(PersonService ps, CourseService cs){
        AbisTrainingService ats = new AbisTrainingService();
        ats.setCs(cs);
        ats.setPs(ps);
        return ats;
    }

}

//this sets up all the components and such from the inner packages