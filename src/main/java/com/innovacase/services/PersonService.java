package com.innovacase.services;

import com.innovacase.models.Person;
import com.innovacase.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonService {
    //Person repomuz icin crud fonksiyonlarinin oldugu servis.

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(long id) throws Exception {
        return personRepository.findById(id).orElseThrow(() -> new Exception()); //new ResourceNotFoundException("Person", "id", id));
    }

    public Person updatePerson(long id, Person personDetails){
        Person person = getPersonById(id);

        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());

        return personRepository.save(person);
    }

    public void deletePerson(long id){
        Person person = getPersonById(id);
        personRepository.delete(person);
    }
}
