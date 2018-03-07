package com.liwc.service;

import com.liwc.model.Type;

import java.util.List;

public interface TypeService {

	
	Type find(String id);

	List<Type> findAll();
	
	Type save(Type t);
	
	
}
