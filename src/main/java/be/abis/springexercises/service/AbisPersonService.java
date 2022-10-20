package be.abis.springexercises.service;

import be.abis.springexercises.exceptions.PersonNotFoundException;
import be.abis.springexercises.model.Person;
import be.abis.springexercises.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class AbisPersonService implements PersonService{

    PersonRepository pr;

    //different way to inject
    @Autowired
    public void setPr(PersonRepository pr) {
        this.pr = pr;
    }

    @Override
    public List<Person> findAllPersons() {
        return pr.getAllPersons();
    }

    @Override
    public Person findPerson(int id) {
        return pr.findPerson(id);
    }

    @Override
    public Person findPerson(String emailAddress, String password) {
        return pr.findPerson(emailAddress, password);
    }

    @Override
    public void addPerson(Person p) throws IOException {
        pr.addPerson(p);
    }

    @Override
    public void deletePerson(Person p) throws PersonNotFoundException {
        pr.deletePerson(p.getPersonId());
    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {
        pr.changePassword(p, newPswd);
    }



}
