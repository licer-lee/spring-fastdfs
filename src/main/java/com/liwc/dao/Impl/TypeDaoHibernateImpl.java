package com.liwc.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liwc.dao.TypeDao;
import com.liwc.model.Type;

@Repository
public class TypeDaoHibernateImpl implements TypeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Type byId(String id) {

		Type t = hibernateTemplate.get(Type.class, id);
		System.out.println("by hibernate");
		return t;
	}

	@Override
	public List<Type> findAll() {
		return hibernateTemplate.loadAll(Type.class);
	}

	@Override
	public Type save(Type t) {
		hibernateTemplate.save(t);
		return t;
	}

}
