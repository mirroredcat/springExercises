package be.abis.springexercises;

import be.abis.springexercises.exceptions.EnrollException;
import be.abis.springexercises.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class AbisTrainingServiceTest {

    @Autowired
    TrainingService ts;

    @Test
    void welcomeMessageComesThrough(){
        assertEquals(ts.getWelcomeMessage(), "Hello how are you");
    }

    @Test
    void johnCanEnrollForMaven() throws EnrollException {
        assertEquals(ts.enrollForSession(ts.getPs().findPerson(1), ts.getCs().findCourse("Maven"), LocalDate.now().plusDays(5)).substring(0,4), "John");
    }

    @Test
    void johnCantEnrollInThePast(){
        assertThrows( EnrollException.class, ()->ts.enrollForSession(ts.getPs().findPerson(1), ts.getCs().findCourse("Maven"), LocalDate.now().minusDays(2)));
    }

}
