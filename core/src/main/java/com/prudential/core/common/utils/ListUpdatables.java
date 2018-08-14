package com.prudential.core.common.utils;

public interface ListUpdatables {

	public boolean isSame(Object another);
	
	public void update(Object updated);
}
