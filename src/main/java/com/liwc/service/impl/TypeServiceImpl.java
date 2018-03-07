package com.liwc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.liwc.dao.TypeDao;
import com.liwc.model.Type;
import com.liwc.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	// 默认小写bean
	@Qualifier(value="typeDaoHibernateImpl")
	private TypeDao dao ;


	@Override
	public Type find(String id) {
		
		return dao.byId(id);
	}

	@Override
	public List<Type> findAll() {
		return dao.findAll();
	}

	
	@Override
	public Type save(Type t) {
		
		return dao.save(t);
	}


}
