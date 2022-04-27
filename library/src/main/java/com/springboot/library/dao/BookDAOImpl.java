package com.springboot.library.dao;

import com.springboot.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDAOImpl implements BookDAO{
    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll() {
        Query query = entityManager.createQuery("from Book");
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    public Book findById(int id) {
       Book book = entityManager.find(Book.class,id);
       return book;
    }

    @Override
    public void save(Book book) {
        Book dbBook = entityManager.merge(book);
        book.setId(dbBook.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Book where id=:bookId");
        query.setParameter("bookId",id);
        query.executeUpdate();
    }
}
