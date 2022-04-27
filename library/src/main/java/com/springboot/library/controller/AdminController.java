package com.springboot.library.controller;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.service.BookService;
import com.springboot.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private PersonService personService;
    private BookService bookService;

    @Autowired
    public AdminController(PersonService personService,BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
    }


    @GetMapping("/studentlist")
    public String getStudentList(Model model){
        List<Person> students = personService.findAll();
        model.addAttribute("students",students);
        return "student-list";
    }

    @GetMapping("/booklist")
    public String getBookList(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book-list";
    }

    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Person person = new Person();
        model.addAttribute("student",person);
        return "addstudent";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student") Person person) {
        personService.save(person);
        return "redirect:/admin/studentlist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book",book);
        return "addbook";
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/admin/booklist";
    }

}
