package com.example.demo_.controllers;

import com.example.demo_.controllers.ApiController;
import com.example.demo_.dao.IAuthorRepository;
import com.example.demo_.models.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthorsController implements ApiController<Author> {

    private final IAuthorRepository _repos;

    public AuthorsController(IAuthorRepository authorsRepos) {
        _repos = authorsRepos;
    }

    @Override
    @GetMapping("/author/all")
    public ModelAndView All() {
        return new ModelAndView("/author/all", "author", _repos.findAll());
    }

    @Override
    @GetMapping("/authors")
    public ModelAndView AllAlternative() {
        return new ModelAndView("redirect:/author/all", "author", _repos.findAll());
    }

    @Override
    @GetMapping("/author/add")
    public ModelAndView AddGet() {
        return new ModelAndView("/author/add", "author", new Author());
    }

    @Override
    @PostMapping("/author/add")
    public ModelAndView AddPost(@ModelAttribute Author author) {
        _repos.save(author);
        return new ModelAndView("redirect:/author/all", "author", _repos.findAll());
    }
}
