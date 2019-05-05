package com.hcl.fsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fsa.domain.Customer;
import com.hcl.fsa.dto.CustomerReqDto;
import com.hcl.fsa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/customer")
	Customer createWllet(@RequestBody CustomerReqDto customerRequest) {
		Customer c = new Customer(0L, customerRequest.getName(), customerRequest.getPhNum(), customerRequest.getMailId());
		return customerService.save(c);

	}

	@GetMapping(path = "/customer")
	List<Customer> getAll() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/customer/{id}")
	Customer getAllById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}

	@PutMapping(path = "/customer/{id}/lock")
	Customer lockCustomer(@PathVariable Long id) {
		return customerService.lockCustomer(id);
	}
	@PutMapping(path = "/customer/{id}/active")
	Customer activeCustomer(@PathVariable Long id) {
		return customerService.activeCustomer(id);
	}

}
