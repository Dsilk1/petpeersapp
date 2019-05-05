package com.hcl.fsa.converter;

import org.springframework.stereotype.Component;

import com.hcl.fsa.domain.Ledger;
import com.hcl.fsa.entity.LedgerEntity;

@Component
public class LedgerConvertor implements IConverter<Ledger, LedgerEntity> {

	@Override
	public LedgerEntity convert(Ledger d) {
		// TODO Auto-generated method stub
		return new LedgerEntity(d.getCustomerId(), d.getBalance(), d.getModified_at());
	}

	@Override
	public Ledger convert(LedgerEntity d) {
		// TODO Auto-generated method stub
		return new Ledger(d.getCustomerId(), d.getBalance(), d.getModified_at());
	}

	

}
