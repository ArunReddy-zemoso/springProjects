package com.springboot.library.service;

import com.springboot.library.entity.Book;
import com.springboot.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

//    @Test
//    void TestfindAll() {
//        when(bookRepository.findAll()).thenReturn(Stream.of(new Book("calculas","calculas in real life","author","Mathmatics")).collect(Collectors.toList()));
//        assertEquals(1,bookService.findAll().size());
//    }
//
//    @Test
//    void TestfindById() {
//        Book book= new Book(2,"calculas","calculas in real life","author","Mathmatics",null);
//        when(bookRepository.findById(2)).thenReturn(Optional.of(book));
//
//    }
//
//    @Test
//    void deleteById() {
//        Book book= new Book(2,"calculas","calculas in real life","author","Mathmatics",null);
//        bookService.deleteById(2);
//        verify(bookService,times(1)).deleteById(2);
//    }
}