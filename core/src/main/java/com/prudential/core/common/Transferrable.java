package com.prudential.core.common;

public interface Transferrable<T extends AbstractDTO> {

	public void populate(T dto);
	
	public void update(T dto);
	
	public T extract(String ... skipProperties);
}
