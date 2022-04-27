package com.springboot.library.dao;

import com.springboot.library.entity.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> findAll();

    public Book findById(int id);

    public void save(Book book);

    public  void delete(int id);
}
