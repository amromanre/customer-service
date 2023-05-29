package com.nttdata.customer.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.customer.models.documents.Customer;
import reactor.core.publisher.Mono;

public interface CustomerDao extends ReactiveMongoRepository<Customer, String>{
    public Mono<Customer> findByDni(String dni);
}
