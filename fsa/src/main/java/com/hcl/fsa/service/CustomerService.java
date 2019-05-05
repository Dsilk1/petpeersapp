package com.hcl.fsa.service;

import java.util.List;

import com.hcl.fsa.domain.Customer;

public interface CustomerService {
	
	Customer save(Customer c);
	Customer getCustomerById(Long cid);
	List<Customer> getAllCustomers();
	Customer lockCustomer(Long cid);
	Customer activeCustomer(Long cid);

}
