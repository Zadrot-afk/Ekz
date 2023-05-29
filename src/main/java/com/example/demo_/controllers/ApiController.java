package com.example.demo_.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface ApiController<T> {
    public ModelAndView AddGet();
    public ModelAndView AddPost(@ModelAttribute T entity);
    public ModelAndView All();

    public ModelAndView AllAlternative();
}
