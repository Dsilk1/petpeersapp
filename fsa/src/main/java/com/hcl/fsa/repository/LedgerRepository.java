package com.hcl.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsa.entity.LedgerEntity;

@Repository
public interface LedgerRepository  extends JpaRepository<LedgerEntity, Long>{

}


