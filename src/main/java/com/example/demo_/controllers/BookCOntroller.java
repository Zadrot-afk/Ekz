package com.example.demo_.controllers;

import com.example.demo_.dao.*;
import org.springframework.ui.Model;

import com.example.demo_.models.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class BookCOntroller implements ApiController<Book> {

    private final IBookRepository _repo;
    private final IAuthorRepository authorRepository;
    private final IPressRepository pressRepository;
    private final IThemeRepository themeRepository;
    private final ICategoryRepository categoryRepository;

    public BookCOntroller(IBookRepository repos, IAuthorRepository authorRepository, IPressRepository pressRepository, IThemeRepository themeRepository, ICategoryRepository categoryRepository) {
        _repo = repos;
        this.authorRepository = authorRepository;
        this.pressRepository = pressRepository;
        this.themeRepository = themeRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    @GetMapping("book/add")
    public ModelAndView AddGet() {
        return new ModelAndView("redirect:/errors/adding");
    }

    @Override
    @PostMapping("book/add")
    public ModelAndView AddPost(@ModelAttribute Book book) {
        return new ModelAndView("redirect:/errors/adding");
    }

    @Override
    @GetMapping("/book/all")
    public ModelAndView All() {
        return new ModelAndView("/book/all", "book", _repo.findAll());
    }

    @Override
    @GetMapping("/book")
    public ModelAndView AllAlternative() {
        return new ModelAndView("redirect:/book/all", "book", _repo.findAll());
    }

    @GetMapping("/book/present")
    public ModelAndView Present() {
        return new ModelAndView("/book/present", "book", _repo.findAvailableBooks());
    }

    @GetMapping("/book/absent")
    public ModelAndView Absent() {
        return new ModelAndView("/book/absent", "book", _repo.findBooksOnHand());
    }

    @GetMapping("/book/out-of-date")
    public ModelAndView OutOfDate() {
        return new ModelAndView("/book/outOfDate", "book", _repo.findOverdueBooks());
    }
    @GetMapping("/book/search")
    public String searchBooks(Model model,
                              @RequestParam(name = "authorId", required = false) Long authorId,
                              @RequestParam(name = "title", required = false) String title,
                              @RequestParam(name = "year", required = false) Integer year,
                              @RequestParam(name = "pressId", required = false) Long pressId,
                              @RequestParam(name = "themeId", required = false) Long themeId,
                              @RequestParam(name = "categoryId", required = false) Long categoryId) {

        List<Book> books = _repo.searchBooks(authorId, title, year, pressId, themeId, categoryId);
        model.addAttribute("books", books);
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("presses", pressRepository.findAll());
        model.addAttribute("themes", themeRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "book/search";
    }
}

