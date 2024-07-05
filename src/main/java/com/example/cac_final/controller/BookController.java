package com.example.cac_final.controller;

import com.example.cac_final.entity.Book;
import com.example.cac_final.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id, @RequestBody Book book) {
        Book bookExisting = bookService.findByBookId(id);
        if(bookExisting != null){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro con id: "+id+" no existe");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBookById(id, book);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        Book book =bookService.deleteBookById(id);
        if (book != null) {
            bookService.deleteBookById(id);
            return ResponseEntity.ok().build(); // Puedes devolver un 204 No Content si prefieres
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor con id: " + id + " no existe");
        }
    }
}
