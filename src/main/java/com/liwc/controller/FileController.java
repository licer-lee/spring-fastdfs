package com.liwc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liwc.model.Attachment;
import com.liwc.service.AttachmentService;

@Controller
@RequestMapping("myfile")
public class FileController {


	@Autowired
	private AttachmentService as ;


	@RequestMapping("index")
	public String toUpload(Model model){

		List<Attachment> attachments = as.findAll();
		model.addAttribute(attachments);
		return "file/index";
	}
	
	
	@RequestMapping("view/{fileId}")
	public String picView(@PathVariable("fileId") String fileId, Model model) {
		
		Attachment at = as.byId(fileId);
		
		model.addAttribute("at", at);
		
		return "file/picView";
	}
	
	

}
