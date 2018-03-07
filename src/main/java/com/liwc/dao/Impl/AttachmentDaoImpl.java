package com.liwc.dao.Impl;

import com.liwc.dao.AttachmentDao;
import com.liwc.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Attachment byId(String id) {

		Attachment t = hibernateTemplate.get(Attachment.class, id);
		return t;
	}

	@Override
	public Attachment save(Attachment attachment) {

		hibernateTemplate.save(attachment);
		return attachment;
	}

	@Override
	public List<Attachment> findAll() {
		return hibernateTemplate.loadAll(Attachment.class);
	}

}
