package com.springboot.library.controller;

import com.springboot.library.entity.Book;
import com.springboot.library.entity.Person;
import com.springboot.library.repository.BookRepository;
import com.springboot.library.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BookRepository bookRepository;

    public LoginController(){}
    public LoginController(PersonRepository personRepository,BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/studentDashboard")
    public String showStudentDashboard(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",authentication.getName());
        Optional<Person> result = personRepository.findByFirstName(authentication.getName());
        Person person=null;
        if(result.isPresent()) { person=result.get(); }
        model.addAttribute("student",person);
        List<Book> books= bookRepository.findAll();
        for(Book book : person.getBooks()) {
            books.remove(book);
        }
        model.addAttribute("totalBooks",books);
        return "studentpage";
    }

    @GetMapping("/adminDashboard")
    public String showAdminDashboard(){
        return "adminpage";
    }
}
