package com.springboot.library.controller;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.entity.User;
import com.springboot.library.service.BookService;
import com.springboot.library.service.PersonService;
import com.springboot.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PersonService personService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    public AdminController(){}
    @Autowired
    public AdminController(PersonService personService,BookService bookService,UserService userService) {
        this.personService = personService;
        this.bookService = bookService;
        this.userService = userService;
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

    @GetMapping("/showStudentFormForUpdate")
    public String showStudentFormForUpdate(@RequestParam("studentId") int id,Model model){
        Person person =personService.findById(id);
        model.addAttribute("student",person);
        return "addstudent";
    }

    @GetMapping("/showBookFormForUpdate")
    public String showBookFormForUpdate(@RequestParam("bookId") int id,Model model){
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        return "addbook";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student") Person person) {
        User user = new User();
        user.setUsername(person.getFirstName());
        user.setId(person.getId());
        user.setPassword("$2a$10$X1PAypC2UiFAOIOkVTkmXO6q6voKoX8acLN3sOwZpRPYSOsqdY9y6");
        user.setRoles("ROLE_STUDENT");
        System.out.println("Admin Controller ==> "+user.toString());
        personService.save(person);
        //userService.save(user);
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

    @GetMapping("/deletestudent")
    public String deleteStudent(@RequestParam("studentId") int id){
        personService.deleteById(id);
        //userService.deleteById(id);
        return "redirect:/admin/studentlist";
    }

    @GetMapping("/deletebook")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.deleteById(id);
        return "redirect:/admin/booklist";
    }
}
