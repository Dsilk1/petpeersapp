package com.hcl.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsa.entity.TransactionEntity;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
