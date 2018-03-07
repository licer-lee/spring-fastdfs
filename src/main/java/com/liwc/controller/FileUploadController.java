package com.liwc.controller;

import com.liwc.service.FileUploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("file")
@ResponseBody
public class FileUploadController {

	private final static Log log = LogFactory.getLog(FileUploadController.class);

	// 文件服务器地址(可配置到文件)
	// private final static String CDN_SERVER = "http:" + File.separator +
	// File.separator +"127.0.0.1:8089"+ File.separator + "spring" +
	// File.separator;

	private final static String CDN_SERVER1 = "http://127.0.0.1:8089/spring/";

	@Autowired
	private FileUploadService fs;

//	@Autowired
//	private AttachmentService as;
	
	
	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public Map<String, Object> upload(@RequestParam("file") MultipartFile[] file, HttpServletRequest request,
			HttpSession session) {

		// 物理路径 D://workspace/webName/
		String realPath = request.getSession().getServletContext().getRealPath("/");
		// 虚拟路径 /webName
		String relaPath = request.getSession().getServletContext().getContextPath();

		// 应用主机地址 http://127.0.0.1:8089/
		// String serverURL =
		// request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
		// + relaPath + "/";
		String serverURL = CDN_SERVER1 + realPath;

		return fs.upload(file, realPath, serverURL);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "uploadFdfs", method = RequestMethod.POST)
	public Map<String, Object> uploadFdfs(@RequestParam("file") MultipartFile file) {
		
		return fs.uploadFdfs(file);
	}

	/**
	 * 下载文件
	 * 
	 * @param fileId
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "download/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@PathVariable("fileId") String fileId, HttpServletRequest request)
			throws IOException {

		/* 优雅的处理方式 https://my.oschina.net/songxinqiang/blog/898901 */

		// 物理路径 D://workspace/webName/
		String realPath = request.getSession().getServletContext().getRealPath("/");

		ResponseEntity<byte[]> re = fs.download(fileId, realPath, CDN_SERVER1);

		return re;

	}

	@RequestMapping(value = "downloadFdfs/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFdfs(@PathVariable("fileId")String fileId, Model model){
		
		return fs.downloadFdfs(fileId);
		
	}
	
	
	@RequestMapping(value = "deleteFdfs/{fileId}")
	public Map<String, Object> deleteFdfs(@PathVariable("fileId")String fileId, Model model){
		
		Map<String, Object> map = new HashMap<String,Object>();
		int code = fs.deleteFdfs(fileId);
		
		if(code == 0)
			map.put("msg", "删除成功！");
		else
			map.put("msg", "删除失败！");
		
		return map;
	}

}
