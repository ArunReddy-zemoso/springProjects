package com.springboot.library.dao;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class PersonDAOImpl implements PersonDAO{

    private EntityManager entityManager;
    @Override
    public List<Person> findAll() {
        Query query = entityManager.createQuery("from Person");
        List<Person> persons = query.getResultList();
        return persons;
    }

    @Override
    public Person findById(int id) {
        Person person = entityManager.find(Person.class,id);
        return person;
    }

    @Override
    public Person findByFirstName(String firstName) {

        return null;
    }


    @Override
    public void save(Person person) {
        Person dbPerson = entityManager.merge(person);
        person.setId(dbPerson.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Person where id=:personId");
        query.setParameter("personId",id);
        query.executeUpdate();
    }
}
