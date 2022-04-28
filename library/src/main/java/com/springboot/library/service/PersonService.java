package com.springboot.library.service;

import com.springboot.library.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public Person findById(int id);

    public Person findByFirstName(String firstName);

    public Person save(Person person);

    public void deleteById(int id);
}
