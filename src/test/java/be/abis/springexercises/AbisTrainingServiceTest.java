package be.abis.springexercises;

import be.abis.springexercises.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AbisTrainingServiceTest {

    @Autowired
    TrainingService ts;

    @Test
    void welcomeMessageComesThrough(){
        assertEquals(ts.getWelcomeMessage(), "Hello how are you");
    }


}
