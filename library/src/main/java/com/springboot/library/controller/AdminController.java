package com.springboot.library.controller;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.entity.User;
import com.springboot.library.service.BookService;
import com.springboot.library.service.PersonService;
import com.springboot.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("/userlist")
    public String getUserList(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }



    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Person person = new Person();
        model.addAttribute("student",person);
        return "addstudent";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book",book);
        return "addbook";
    }
    @GetMapping("/adduser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "adduser";
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

    @GetMapping("/showUserFormForUpdate")
    public String showUserFormForUpdate(@RequestParam("userId") int id,Model model){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        return "adduser";
    }


    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student") Person person) {
        personService.save(person);
        return "redirect:/admin/studentlist";
    }


    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/admin/booklist";
    }

    @PostMapping("/saveuser")
    public String saveuser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/admin/userlist";
    }

    @GetMapping("/deletestudent")
    public String deleteStudent(@RequestParam("studentId") int id){
        personService.deleteById(id);
        Person person=personService.findById(id);
        userService.deleteByUsername(person.getFirstName());
        return "redirect:/admin/studentlist";
    }

    @GetMapping("/deletebook")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.deleteById(id);
        return "redirect:/admin/booklist";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("userId") int id){
        userService.deleteById(id);
        return "redirect:/admin/userlist";
    }
}
