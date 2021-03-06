package com.nervelife.springbootgcpjava.domain.repositores;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.nervelife.springbootgcpjava.domain.entities.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends DatastoreRepository<User, Long> {

    User findByUsername(String userName);
    
}
