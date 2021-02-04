package com.nervelife.springbootgcpjava.domain.entities;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity(name = "Users")
public class User {

    @Id
    Long id;

    String username;

    String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    
    
}
