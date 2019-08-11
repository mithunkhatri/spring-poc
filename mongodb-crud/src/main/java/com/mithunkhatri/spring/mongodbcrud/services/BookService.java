package com.mithunkhatri.spring.mongodbcrud.services;

import com.mithunkhatri.spring.mongodbcrud.models.Book;
import com.mithunkhatri.spring.mongodbcrud.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBook(final UUID bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(final Book book) {
        findBook(book.getId());
        bookRepository.save(book);
    }

    public void deleteBook(final UUID bookId) {
        final Book book = new Book();
        book.setId(bookId);
        bookRepository.delete(book);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
