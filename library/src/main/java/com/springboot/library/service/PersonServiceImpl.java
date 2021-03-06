package com.springboot.library.service;

import com.springboot.library.entity.Person;
import com.springboot.library.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    public PersonServiceImpl(){}
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        Optional<Person> result = personRepository.findById(id);
        Person person=null;
        if(result.isPresent()) { person=result.get(); }
        else{ throw new NullPointerException("Did not find person of id - "+id); }
        return person;
    }

    @Override
    public Person findByFirstName(String firstName) {
        Optional<Person> result = personRepository.findByFirstName(firstName);
        Person person=null;
        if(result.isPresent()) { person=result.get(); }
        else{ throw new NullPointerException("Did not find person of name - "+firstName);}
        return person;
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
