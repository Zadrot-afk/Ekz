package com.example.demo_.controllers;

import com.example.demo_.dao.ITeacherRepository;
import com.example.demo_.models.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TeacherController implements ApiController<Teacher> {

    private final ITeacherRepository _repos;

    public TeacherController(ITeacherRepository repos) {
        _repos = repos;
    }


    @Override
    @GetMapping("/teacher/all")
    public ModelAndView All() {
        return new ModelAndView("/teacher/all", "teacher", _repos.findAll());
    }

    @Override
    @GetMapping("/teachers")
    public ModelAndView AllAlternative() {
        return new ModelAndView("redirect:/teacher/all", "teacher", _repos.findAll());
    }

    @Override
    @GetMapping("/teacher/add")
    public ModelAndView AddGet() {
        return new ModelAndView("/teacher/add", "teacher", new Teacher());
    }


    @Override
    @PostMapping("/teacher/add")
    public ModelAndView AddPost(@ModelAttribute Teacher teacher) {
        _repos.save(teacher);
        return new ModelAndView("redirect:/teacher/all", "teacher", _repos.findAll());
    }
}
