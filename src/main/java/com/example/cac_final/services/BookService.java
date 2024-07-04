package com.example.cac_final.services;
import com.example.cac_final.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findByBookId(long id);
    Book createBook(Book book);
    Book updateBookById(long id,Book book);
    Book deleteBookById(long id);
}

