package com.liwc.service;

import com.liwc.dao.AttachmentDao;
import com.liwc.dao.TypeDao;
import com.liwc.model.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class TypeServiceTestImpl {

    private static final Log log = LogFactory.getLog(TypeServiceTestImpl.class);


    @Autowired
    @Qualifier(value="typeDaoHibernateImpl")
    private TypeDao dao;
    
    @Autowired
    private AttachmentDao ad;


    @Test
    public void findTest(){
//        List<Type> types = dao.findAll();
//
//        log.info(types.size());
        

    	ad.findAll();

    }


}
