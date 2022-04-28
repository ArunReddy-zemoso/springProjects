package com.springboot.library.repository;

import com.springboot.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    //List<Book> findByStudentId(int personId);
}
