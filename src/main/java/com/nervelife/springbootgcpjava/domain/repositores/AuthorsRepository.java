// AuthorsRepository.java
package com.nervelife.springbootgcpjava.domain.repositores;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.nervelife.springbootgcpjava.domain.entities.Author;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends DatastoreRepository<Author, Long> {
    
}