package com.nervelife.springbootgcpjava.domain.repositores;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import com.nervelife.springbootgcpjava.domain.entities.Publisher;

import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends DatastoreRepository<Publisher, Long> {

    Publisher findByCompany(String company);
    
}