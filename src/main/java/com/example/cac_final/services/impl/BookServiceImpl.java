package com.example.cac_final.services.impl;

import com.example.cac_final.entity.Autor;
import com.example.cac_final.entity.Book;
import com.example.cac_final.repository.AutorRepository;
import com.example.cac_final.repository.BookRepository;
import com.example.cac_final.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByBookId(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        List<Autor> autores = new ArrayList<>();
        for (Autor autor : book.getAutores()) {
            Autor existingAutor = autorRepository.findById(autor.getId()).orElse(null);
            if (existingAutor != null) {
                autores.add(existingAutor);
            }
        }
        book.setAutores(autores);
        return bookRepository.save(book);
    }
    

    @Override
    public Book updateBookById(long id, Book bookActualizado) {
        Book bookExistente = bookRepository.findById(id).orElse(null);
        if (bookExistente != null) {
            bookExistente.setTitulo(bookActualizado.getTitulo());
            bookExistente.setIsbn(bookActualizado.getIsbn());
            bookExistente.setAutores(bookActualizado.getAutores());
            return bookRepository.save(bookExistente);
        }
        return null;
    }

    @Override
    public Book deleteBookById(long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            return book;
        }
        return null;
    }
}
