package com.example.demo_.controllers;


import com.example.demo_.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Index(Model model)
    {
        return"home/index";
    }
}
