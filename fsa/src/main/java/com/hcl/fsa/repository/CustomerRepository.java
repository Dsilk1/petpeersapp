package com.hcl.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsa.entity.CustomerEntity;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity, Long>{

}


