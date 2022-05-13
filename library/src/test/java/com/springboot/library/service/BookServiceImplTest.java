package com.springboot.library.service;

import com.springboot.library.entity.Book;
import com.springboot.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {
    @MockBean
    BookRepository bookRepository;

    @Test
    void TestfindAll() {
        when(bookRepository.findAll()).thenReturn(Stream.of(new Book(1,"calculas ","calculas in real life","arun","mathmatics",null)).collect(Collectors.toList()));
        assertEquals(1,bookRepository.findAll().size());
    }

    @Test
    void findById() {
        Book book = new Book(1,"calculas ","calculas in real life","arun","mathmatics",null);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));
        assertEquals(Optional.of(book),bookRepository.findById(1));
    }

    @Test
    void save() {
        Book book = new Book("theory of relativity","about the time drift","Einstein","science");
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(bookRepository.save(book),book);
    }

    @Test
    void deleteById() {
        Book book = new Book(1,"theory of relativity","about the time drift","Einstein","science",null);
        bookRepository.deleteById(1);
        verify(bookRepository,times(1)).deleteById(1);
    }
}