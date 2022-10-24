package be.abis.springexercises;

import be.abis.springexercises.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SomeCourseServiceTest {

    @Autowired
    @Qualifier("fallback")
    CourseService cs;

    @Test
    public void testCourseIsReturned(){
        assertEquals(cs.findCourse(7900).getLongTitle(), "TestCourse");
    }

}
