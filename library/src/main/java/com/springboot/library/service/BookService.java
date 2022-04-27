package com.springboot.library.service;

import com.springboot.library.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();

    public Book findById(int id);

    public void save(Book book);

    public void deleteById(int id);

}
