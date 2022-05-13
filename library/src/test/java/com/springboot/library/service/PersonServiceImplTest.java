package com.springboot.library.service;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonServiceImplTest {
    @MockBean
    private PersonRepository personRepository;

    @Test
    void TestFindAllPersons() {
        when(personRepository.findAll()).thenReturn(Stream.of(new Person("arun","marella","arun@gmail.com")).collect(Collectors.toList()));
        assertEquals(1,personRepository.findAll().size());
    }

    @Test
    void TestfindById() {
        Person person = new Person(4,"arun","marella","arun@gamil.com",null);
        when(personRepository.findById(4)).thenReturn(Optional.of(person));
        assertEquals(Optional.of(person),personRepository.findById(4));
    }

    @Test
    void Testsave() {
        List<Book> books = new ArrayList<Book>();
        Person student = new Person(1,"arun","marella","arun@gmail.com",books);
        books.add(new Book("theory of relativity","about the time drift","Einstein","science"));
        when(personRepository.save(student)).thenReturn(student);
        assertEquals(student,personRepository.save(student));
    }

    @Test
    void TestdeleteById() {
        Person person = new Person(4,"arun","marella","arun@gamil.com",null);
        personRepository.deleteById(4);
        verify(personRepository,times(1)).deleteById(4);
    }
}