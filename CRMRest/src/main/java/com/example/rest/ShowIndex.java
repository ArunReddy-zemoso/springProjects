package com.example.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowIndex {

    @RequestMapping("/")
    public String showFile(){
        return "index.jsp";
    }
}
