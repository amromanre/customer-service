package com.nttdata.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.customer.models.dao.CustomerDao;
import com.nttdata.customer.models.documents.Customer;
import com.nttdata.customer.models.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * 
 * @author aromanre
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	@Override
	public Flux<Customer> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Customer> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Customer> findByDni(String dni) {
		return dao.findByDni(dni);
	}

	@Override
	public Mono<Customer> save(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public Mono<Void> delete(Customer customer) {
		return dao.delete(customer);
	}

}
