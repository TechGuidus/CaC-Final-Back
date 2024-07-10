package com.example.cac_final.controller;

import com.example.cac_final.entity.Autor;
import com.example.cac_final.entity.Book;
import com.example.cac_final.repository.AutorRepository;
import com.example.cac_final.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);
        List<Book> libros = bookRepository.findAll();
        model.addAttribute("libros", libros);
        return "index";
    }

}
