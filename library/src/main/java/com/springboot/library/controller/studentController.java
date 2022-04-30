package com.springboot.library.controller;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.repository.BookRepository;
import com.springboot.library.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class studentController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BookRepository bookRepository;

    public studentController(){}
    @Autowired
    public studentController(PersonRepository personRepository,BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/deletebook")
    public String deleteBook(@RequestParam("bookId") int bid,@RequestParam("studentId") int sid){
        Optional<Person> personResult=personRepository.findById(sid);

        Optional<Book> bookResult=bookRepository.findById(bid);

        Person person=null;
        if(personResult.isPresent()) { person=personResult.get(); }

        Book book=null;
        if(bookResult.isPresent()) { book=bookResult.get(); }

//        System.out.println(person.toString());
//        System.out.println(book.toString());

        person.deleteBook(book);

        personRepository.save(person);

        return "redirect:/studentDashboard";
    }

    @GetMapping("/addbooktostudent")
    public String addbooktostudent(@RequestParam("bookId") int bid,@RequestParam("studentId") int sid){
        Optional<Person> personResult=personRepository.findById(sid);

        Optional<Book> bookResult=bookRepository.findById(bid);

        Person person=null;
        if(personResult.isPresent()) { person=personResult.get(); }

        Book book=null;
        if(bookResult.isPresent()) { book=bookResult.get(); }

        System.out.println(person.toString());
        System.out.println(book.toString());

        person.addBook(book);

        personRepository.save(person);

        return "redirect:/studentDashboard";
    }

}
