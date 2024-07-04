package com.example.cac_final.services.impl;

import com.example.cac_final.entity.Autor;
import com.example.cac_final.repository.AutorRepository;
import com.example.cac_final.services.AutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {


    @Autowired
    private AutorRepository autorRepository;

    private static final Logger logger = LoggerFactory.getLogger(AutorServiceImpl.class);


    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(long id) {
        Autor autor = autorRepository.findById(id).orElse(null);
        logger.debug("Resultado de autorRepository.findById: " + autor);
        return autor;
    }
    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutorById(long id, Autor autorActualizado) {
        Autor autorExistente = autorRepository.findById(id).orElse(null);
        if (autorExistente != null) {
            // Actualiza los campos relevantes del autor existente
            autorExistente.setNombreCompleto(autorActualizado.getNombreCompleto());
            // Agrega más campos según tus necesidades

            // Guarda los cambios en la base de datos
            return autorRepository.save(autorExistente);
        }
        return null; // Autor no encontrado
    }

    @Override
    public Autor deleteAutorById(long id) {
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autorRepository.delete(autor);
            return autor;
        }
        return null;
    }

   
}
