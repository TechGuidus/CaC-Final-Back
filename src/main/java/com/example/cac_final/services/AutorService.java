package com.example.cac_final.services;
import com.example.cac_final.entity.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> findAll();
    Autor getAutorById(long id);
    Autor createAutor(Autor autor);
    Autor updateAutorById(long id, Autor autorActualizado);
    Autor deleteAutorById(long id);
}

