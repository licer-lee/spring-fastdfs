package com.liwc.dao;

import com.liwc.model.Attachment;

import java.util.List;

public interface AttachmentDao {

    Attachment save(Attachment attachment);

    List<Attachment> findAll();

    Attachment byId(String id);


}
