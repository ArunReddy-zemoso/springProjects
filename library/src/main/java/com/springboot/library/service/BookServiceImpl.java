package com.springboot.library.service;

import com.springboot.library.entity.Book;
import com.springboot.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

//    @Override
//    public List<Book> findByStudentId(int personId) {
//        return bookRepository.findByStudentId(personId);
//    }

    @Override
    public Book findById(int id) {
        Optional<Book> result = bookRepository.findById(id);
        Book book=null;
        if(result.isPresent()) { book=result.get(); }
        else{ throw new RuntimeException("Did not find book id - "+id); }
        return book;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
