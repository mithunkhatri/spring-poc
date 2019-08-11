package com.mithunkhatri.spring.mongodbcrud.controllers;

import com.mithunkhatri.spring.mongodbcrud.models.Book;
import com.mithunkhatri.spring.mongodbcrud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity getBook(@PathVariable("bookId") UUID bookId) {
        Optional<Book> bookOptional = bookService.findBook(bookId);
        if(bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable("bookId") UUID bookId,
                           @RequestBody Book book) {
        book.setId(bookId);
        bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") UUID bookId) {
        bookService.deleteBook(bookId);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }
}
