package com.hcl.fsa.converter;

import com.hcl.fsa.domain.IDomain;
import com.hcl.fsa.entity.IEntity;

public interface IConverter<T extends IDomain,M extends IEntity>{
	M convert(T d);
	T convert(M d);
}
