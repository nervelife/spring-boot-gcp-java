// Author.java
package com.nervelife.springbootgcpjava.domain.entities;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

import org.springframework.data.annotation.Id;

@Entity(name="Authors")
public class Author {

    @Id
    Long id;

    String name;

    Boolean alive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

}