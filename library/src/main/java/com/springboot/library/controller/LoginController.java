package com.springboot.library.controller;

import com.springboot.library.entity.Person;
import com.springboot.library.repository.PersonRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    PersonRepository personRepository;

    public LoginController(PersonRepository personRepository){
        this.personRepository = personRepository;
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
        System.out.println(authentication.getName());
        System.out.println(personRepository.findByFirstName(authentication.getName()));
        return "studentpage";
    }

    @GetMapping("/adminDashboard")
    public String showAdminDashboard(){
        return "adminpage";
    }
}
