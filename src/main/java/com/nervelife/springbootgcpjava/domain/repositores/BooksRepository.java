// BooksRepository.java
package com.nervelife.springbootgcpjava.domain.repositores;

import java.util.List;

import com.google.cloud.datastore.Key;
import com.nervelife.springbootgcpjava.domain.entities.Author;
import com.nervelife.springbootgcpjava.domain.entities.Book;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.repository.query.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends DatastoreRepository<Book, Key> {
    
    List<Book> findByAuthor(Author author);

    List<Book> findByCategory(String category);

    @Query("SELECT * FROM Books WHERE __key__ HAS ANCESTOR @publisherKey")
    List<Book> findByPublisher(@Param("publisherKey") Key publisherKey);
    
}