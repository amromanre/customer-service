package com.nttdata.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.customer.models.documents.Customer;
import com.nttdata.customer.models.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

/**
 * Client class, which manages client information.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	/**
	 * Method that returns the list of customers
	 * @return Mono<ResponseEntity<Flux<Customer>>>
	 */
	@GetMapping()
	public Mono<ResponseEntity<Flux<Customer>>> toList(){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll()));
	}

	/**
	 * Method to search for a new client by id
	 * @param id
	 * @return Mono<ResponseEntity<Customer>>
	 */
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Customer>> lookForClient(@PathVariable String id){
		return service.findById(id).map(c -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * Method that looks for a client by DNI
	 * @param dni
	 * @return Mono<ResponseEntity<Customer>>
	 */
	@GetMapping("/document/{dni}")
	public Mono<ResponseEntity<Customer>> lookForClientByDni(@PathVariable String dni){
		return service.findByDni(dni).map(c -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 *	Method to create a new client
	 * @param customer
	 * @return Mono<ResponseEntity<Customer>>
	 */
	@PostMapping
	public Mono<ResponseEntity<Customer>> newClient(@RequestBody Customer customer){
		if(customer.getCreateAt() == null){
			customer.setCreateAt(new Date());
		}
		return service.save(customer)
				.map(c -> ResponseEntity.created(URI.create("/api/customers/".concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
				);
	}
}
