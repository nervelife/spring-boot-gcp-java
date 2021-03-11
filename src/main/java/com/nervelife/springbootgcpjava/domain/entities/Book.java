// Book.java
package com.nervelife.springbootgcpjava.domain.entities;

import com.google.cloud.datastore.Key;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

@Entity(name="Books")
public class Book {

    @Id
    Key key;

    String title;

    String category;

    @Reference
    Author author;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}