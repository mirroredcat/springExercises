package be.abis.springexercises;

import be.abis.springexercises.repository.CourseRepository;
import be.abis.springexercises.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AbisCourseServiceTest {

    @Autowired
    CourseService acr;

    @Test
    void courseWithId7900IsFound(){
        assertEquals(acr.findCourse(7900).getShortTitle(), "Workshop SQL");
    }

}
