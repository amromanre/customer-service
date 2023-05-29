package com.nttdata.customer.models.service;

import com.nttdata.customer.models.documents.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	
	public Flux<Customer> findAll();
	
	public Mono<Customer> findById(String id);

	public Mono<Customer> findByDni(String dni);
	
	public Mono<Customer> save(Customer customer);
	
	public Mono<Void> delete(Customer customer);
}
