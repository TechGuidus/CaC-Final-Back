package com.example.cac_final.services;
import com.example.cac_final.entity.AutorHasBook;

import java.util.List;

public interface AutorHasBookService {
    List<AutorHasBook> findAll();
    AutorHasBook findById(long id);
}

