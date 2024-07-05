package com.example.cac_final.services.impl;

import com.example.cac_final.entity.AutorHasBook;
import com.example.cac_final.repository.AutorHasBookRespository;
import com.example.cac_final.services.AutorHasBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorHasBookImpl implements AutorHasBookService {
    @Autowired
    private AutorHasBookRespository autorHasRespository  ;

    @Override
    public List<AutorHasBook> findAll() {
       return autorHasRespository.findAll();
    }

    @Override
    public AutorHasBook findById(long id) {
        return autorHasRespository.findById(id).get();
    }

 
}
