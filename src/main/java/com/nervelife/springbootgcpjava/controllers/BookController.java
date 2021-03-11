package com.nervelife.springbootgcpjava.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.gcp.data.datastore.core.DatastoreTemplate;
import com.google.cloud.datastore.Key;

import com.nervelife.springbootgcpjava.domain.entities.Author;
import com.nervelife.springbootgcpjava.domain.entities.Book;
import com.nervelife.springbootgcpjava.domain.entities.Publisher;
import com.nervelife.springbootgcpjava.domain.repositores.AuthorsRepository;
import com.nervelife.springbootgcpjava.domain.repositores.BooksRepository;
import com.nervelife.springbootgcpjava.domain.repositores.PublishersRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    BooksRepository bookRepo;

    @Autowired
    AuthorsRepository authorRepo;

    @Autowired
    PublishersRepository publishersRepo;

    @Autowired
    DatastoreTemplate dsTemplate;

    @GetMapping("/book-by-author/{authorId}")
    public List<Book> bookByAuthor(@PathVariable Long authorId) {
        Optional<Author> author = authorRepo.findById(authorId);
        if (author.isPresent()) {
            return bookRepo.findByAuthor(author.get());
        }
        return Collections.emptyList();
    }

    @GetMapping("/book-by-publisher/{publisherId}")
    public List<Book> bookByPublisher(@PathVariable Long publisherId) {
        Key publisherKey = dsTemplate.createKey(Publisher.class, publisherId);
        return bookRepo.findByPublisher(publisherKey);
    }

    @GetMapping("/save-book-url/{title}/{category}")
    public String saveBookUrl(@PathVariable String title, @PathVariable String category) {

        Book book = new Book();
        book.setTitle(title);
        book.setCategory(category);

        bookRepo.save(book);

        return "OK";
    }

    @PostMapping("/save-book/{company}")
    public String saveBook(@RequestBody Book book, @PathVariable String company) {

        Publisher publisher = publishersRepo.findByCompany(company);

        publisher.getBooks().add(book);

        publishersRepo.save(publisher);

        return "OK";
    }

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam String category) {

        return bookRepo.findByCategory(category);
    }
}