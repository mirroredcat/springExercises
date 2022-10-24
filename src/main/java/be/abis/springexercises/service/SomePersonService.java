package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.PersonNotFoundException;
import be.abis.springexercises.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Profile("test")
public class SomePersonService implements PersonService{
    @Override
    public List<Person> findAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        return null;
    }

    @Override
    public Person findPerson(String emailAddress, String password) {
        Person p = new Person();
        p.setFirstName("Clau");
        p.setEmailAddress("Clau.rules@potato.com");
        p.setPassword("woopwoop");
        return p;
    }

    @Override
    public void addPerson(Person p) throws IOException {

    }

    @Override
    public void deletePerson(Person p) throws PersonNotFoundException {

    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {

    }
}
