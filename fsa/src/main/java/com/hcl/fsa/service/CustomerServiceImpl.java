package com.hcl.fsa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsa.common.IConstants;
import com.hcl.fsa.converter.IConverter;
import com.hcl.fsa.domain.Customer;
import com.hcl.fsa.entity.CustomerEntity;
import com.hcl.fsa.repository.CustomerRepository;
import com.hcl.fsa.exception.CustomException;
import com.hcl.fsa.exception.MessageCode;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	IConverter<Customer, CustomerEntity> customerConverter;

	@Override
	public Customer save(Customer c) {
		try {
			return customerConverter.convert(customerRepository.save(customerConverter.convert(c)));
		} catch (Exception e) {

			throw new RuntimeException();
		}
	}

	@Override
	public Customer getCustomerById(Long cid) {
		Optional<CustomerEntity> custEntity = customerRepository.findById(cid);
		if (custEntity.isPresent()) {
			return customerConverter.convert(custEntity.get());
		} else {
			throw new CustomException(MessageCode.USER_RECORD_NOT_FOUND);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll().stream().map(u -> customerConverter.convert(u))
				.collect(Collectors.toList());

	}

	@Override
	public Customer lockCustomer(Long cid) {
		Optional<CustomerEntity> custEntity = customerRepository.findById(cid);
		if (custEntity.isPresent()) {
			custEntity.get().setStatus(IConstants.LOCK);
			return customerConverter.convert(custEntity.get());
		} else {
			throw new CustomException(MessageCode.USER_RECORD_NOT_FOUND);
		}
	}

	@Override
	public Customer activeCustomer(Long cid) {
		Optional<CustomerEntity> custEntity = customerRepository.findById(cid);
		if (custEntity.isPresent()) {
			custEntity.get().setStatus(IConstants.ACTIVE);
			return customerConverter.convert(custEntity.get());
		} else {
			throw new CustomException(MessageCode.USER_RECORD_NOT_FOUND);
		}
	}

}
