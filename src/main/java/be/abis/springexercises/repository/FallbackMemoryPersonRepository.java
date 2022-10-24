package be.abis.springexercises.repository;

import be.abis.springexercises.model.Address;
import be.abis.springexercises.model.Company;
import be.abis.springexercises.model.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@ConditionalOnMissingBean(value = FilePersonRepository.class)
public class FallbackMemoryPersonRepository implements PersonRepository {

    private ArrayList<Person> allPersons = new ArrayList<>();

    public FallbackMemoryPersonRepository(){
        allPersons.add(new Person(1,"John","Doe",35,"jdoe@abis.be","def456","nl", new Company("Abis","016/245610", "0428.407.725", new Address("Diestsevest", "Leuven","3000",21))));
        allPersons.add(new Person(2,"Mary","Jones",27,"mjones@abis.be","abc123", "fr",new Company ("Abis","016/245610",  "0428.407.725", new Address("Diestsevest","Leuven","3000", 32))));
        allPersons.add(new Person(3,"Bob","Smith",53,"bob.smith@oracle.com","abc986","en", new Company("Oracle","02/7191211", "0440.966.354", new Address("Medialaan", "Vilvoorde", "1800", 32))));
    }


    @Override
    public ArrayList<Person> getAllPersons() {
        return allPersons;
    }

    @Override
    public Person findPerson(int id) {
        System.out.println("This was done form memory");
        return allPersons.stream().filter(p->p.getPersonId()==id).findFirst().orElse(null);
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        if (emailAddress == null || passWord == null) {
            return null;
        }
        for(Person pers:allPersons) {
            if (pers.getEmailAddress().equalsIgnoreCase(emailAddress) && pers.getPassword().equals(passWord)) {
                return pers;
            }
        }
        return null;
    }

    @Override
    public void addPerson(Person p){
        allPersons.add(p);
    }

    @Override
    public void deletePerson(int id) {
        Person found = findPerson(id);
        allPersons.remove(found);
    }

    @Override
    public void changePassword(Person p, String newPswd) {
        Person found = findPerson(p.getPersonId());
        p.setPassword(newPswd);
    }
}
