package com.example.cac_final.repository;

import com.example.cac_final.entity.AutorHasBook;
import com.example.cac_final.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorHasBookRespository extends JpaRepository<AutorHasBook, Long> {

    Book deleteBookById(long id);
}
