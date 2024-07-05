package com.example.cac_final.controller;

import com.example.cac_final.entity.Autor;
import com.example.cac_final.services.AutorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {



    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor);
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAutorById(@PathVariable long id) {
        Autor autor = autorService.getAutorById(id);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor con id: "+id+" no existe");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutor(@PathVariable long id, @RequestBody Autor autorActualizado) {
        Autor autorExistente = autorService.getAutorById(id);
        if (autorExistente != null) {
            Autor autorActualizadoGuardado = autorService.updateAutorById(id, autorActualizado);
            return ResponseEntity.ok(autorActualizadoGuardado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor con id: "+id+" no existe");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable long id) {
        Autor autor = autorService.getAutorById(id);
        if (autor != null) {
            autorService.deleteAutorById(id);
            return ResponseEntity.ok().build(); // Puedes devolver un 204 No Content si prefieres
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor con id: " + id + " no existe");
        }
    }
}
