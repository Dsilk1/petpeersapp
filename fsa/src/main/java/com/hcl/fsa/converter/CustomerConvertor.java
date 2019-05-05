package com.hcl.fsa.converter;

import org.springframework.stereotype.Component;

import com.hcl.fsa.domain.Customer;
import com.hcl.fsa.entity.CustomerEntity;

@Component
public class CustomerConvertor implements IConverter<Customer, CustomerEntity> {

	@Override
	public CustomerEntity convert(Customer d) {

		return new CustomerEntity(d.getCustomerId(), d.getName(), d.getPhNum(), d.getMailId(), d.getStatus());
	}

	@Override
	public Customer convert(CustomerEntity d) {
		// TODO Auto-generated method stub
		return new Customer(d.getCustomerId(), d.getName(), d.getPhNum(), d.getMailId(), d.getStatus());
	}

}
