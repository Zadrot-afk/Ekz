package com.example.demo_.controllers;

import com.example.demo_.models.Identity.AppUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/user/login", "user", new AppUser());
    }

    @GetMapping("/home")
    @Secured("USER")
    public ModelAndView home() {
        return new ModelAndView("home/index", "data", new Object());
    }
}
