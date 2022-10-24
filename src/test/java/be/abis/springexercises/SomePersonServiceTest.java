package be.abis.springexercises;

import be.abis.springexercises.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class SomePersonServiceTest {

    @Autowired
    PersonService ps;

    @Test
    public void personReturnedIsMe(){
        assertEquals(ps.findPerson("Clau.rules@potato.com", "woopwoop").getFirstName(), "Clau");
    }

}
