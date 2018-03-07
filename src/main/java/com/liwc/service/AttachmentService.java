package com.liwc.service;

import com.liwc.model.Attachment;

import java.util.List;

public interface AttachmentService {

	
	Attachment save(Attachment attachment);

	List<Attachment> findAll();

	Attachment byId(String id);
	
}
