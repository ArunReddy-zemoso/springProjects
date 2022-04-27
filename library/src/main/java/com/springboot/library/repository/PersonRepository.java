package com.springboot.library.repository;

import com.springboot.library.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findByFirstName(String firstName);
}
