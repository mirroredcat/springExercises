package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.PersonNotFoundException;
import be.abis.springexercises.model.Person;

import java.io.IOException;
import java.util.List;

public interface  PersonService {

    public List<Person> findAllPersons();
    public Person findPerson(int id);
    public Person findPerson(String emailAddress, String password);
    public void addPerson(Person p) throws IOException;
    public void deletePerson(Person p) throws PersonNotFoundException;
    public void changePassword(Person p, String newPswd) throws IOException;

}
