package com.nervelife.springbootgcpjava.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import com.google.cloud.datastore.Key;

import com.nervelife.springbootgcpjava.domain.entities.Author;
import com.nervelife.springbootgcpjava.domain.entities.Book;
import com.nervelife.springbootgcpjava.domain.entities.Publisher;
import com.nervelife.springbootgcpjava.domain.repositores.AuthorsRepository;
import com.nervelife.springbootgcpjava.domain.repositores.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    BooksRepository bookRepo;

    @Autowired
    AuthorsRepository authorRepo;

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
}