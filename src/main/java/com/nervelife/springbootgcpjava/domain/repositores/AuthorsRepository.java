// AuthorsRepository.java
package com.nervelife.springbootgcpjava.domain.repositores;

import com.nervelife.springbootgcpjava.domain.entities.Author;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends DatastoreRepository<Author, Long> {
    
}