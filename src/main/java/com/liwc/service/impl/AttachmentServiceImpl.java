package com.liwc.service.impl;

import com.liwc.dao.AttachmentDao;
import com.liwc.dao.TypeDao;
import com.liwc.model.Attachment;
import com.liwc.model.Type;
import com.liwc.service.AttachmentService;
import com.liwc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentDao dao ;


	@Override
	public Attachment save(Attachment attachment) {
		return dao.save(attachment);
	}

	@Override
	public List<Attachment> findAll() {
		return dao.findAll();
	}

	@Override
	public Attachment byId(String id) {
		return dao.byId(id);
	}
}
