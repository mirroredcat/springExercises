package be.abis.springexercises;

import be.abis.springexercises.exceptions.PersonNotFoundException;
import be.abis.springexercises.model.Address;
import be.abis.springexercises.model.Company;
import be.abis.springexercises.model.Person;
import be.abis.springexercises.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("dev")
public class AbisPersonServiceTest {

    @Autowired
    PersonService aps;

    @Test
    void personWithID1isFound(){
        assertEquals(aps.findPerson(1).getFirstName(), "John");
    }

    @Test
    void personWithEmailAndPassIsFound(){
        assertEquals(aps.findPerson("jdoe@abis.be", "def456").getFirstName(), "John");
    }

    @Test
    @Order(1)
    void personIsAdded(){
        Person p = new Person();
        Address address = new Address();
        Company c = new Company();

        c.setAddress(address);
        c.setName("IBM");
        c.setTelephoneNumber("12345678");
        c.setVatNr("67812367812");

        address.setNr(21);
        address.setStreet("Lynckxstraat");
        address.setTown("Lier");
        address.setZipcode("1234");
        p.setPersonId(4);p.setFirstName("Jill");p.setLastName("Sims");p.setAge(24);
        p.setEmailAddress("jill.sims@whatever.com");p.setPassword("uihefuihsdfh");
        p.setLanguage("en");
        p.setCompany(c);
        try {
            aps.addPerson(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(aps.findAllPersons().size(), 4);
    }

    @Test
    @Order(2)
    void personHasChangedPasswd(){
        Person p = aps.findPerson(4);
        try {
            aps.changePassword(p, "potato");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(aps.findPerson(4).getPassword(), "potato");
    }

    @Test
    @Order(3)
    void personIsDeleted(){
        try {
            aps.deletePerson(aps.findPerson(4));
        } catch (PersonNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals(aps.findAllPersons().size(), 3);

    }
}
