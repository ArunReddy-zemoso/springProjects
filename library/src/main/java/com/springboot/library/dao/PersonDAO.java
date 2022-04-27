package com.springboot.library.dao;

import com.springboot.library.entity.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> findAll();

    public Person findById(int id);

    public Person findByFirstName(String firstName);

    public void save(Person person);

    public  void delete(int id);
}
