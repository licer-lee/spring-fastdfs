package com.liwc.dao;

import com.liwc.model.Type;

import java.util.List;

public interface TypeDao {

    Type byId(String id);

    List<Type> findAll();
    
    Type save(Type t);
    
}
