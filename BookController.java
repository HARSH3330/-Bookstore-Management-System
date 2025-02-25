package com.example.Bookstore.controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Book Added Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
}
