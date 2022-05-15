package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.service.AuthorRepository;
import guru.springframework.spring5webapp.service.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rumman
 * @since 5/15/22
 */
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String showBooks(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
