package com.liwc.service.impl;

import com.liwc.fastdfs.FastDFSFile;
import com.liwc.fastdfs.FileManager;
import com.liwc.model.Attachment;
import com.liwc.service.AttachmentService;
import com.liwc.service.FileUploadService;
import com.liwc.util.DateUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static final Log logger = LogFactory.getLog(FileUploadServiceImpl.class);

	@Autowired
	private AttachmentService as;

	@Override
	public Map<String, Object> upload(MultipartFile[] files, String basePath, String relaPath) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (files.length <= 0) {
			map.put("msg", "没有要上传的文件！");
			return null;
		}

		String dateTime = DateUtil.getDateTime();
		String midPath = "/upload/" + dateTime + "/";

		Attachment attachment = null;
		for (int i = 0; i < files.length; i++) {

			MultipartFile myfiles = files[i];
			if (myfiles.isEmpty()) {
				logger.warn("no file to be uploaded");
			}

			// 文件原名称
			String orgnName = myfiles.getOriginalFilename();
			File localFile = new File(basePath + midPath + orgnName);
			if (!localFile.exists()) {
				localFile.mkdirs();
			}

			try {
				myfiles.transferTo(localFile);
				map.put("msg", "上传成功！");
				map.put("realPath", basePath + midPath + orgnName);
				map.put("url", midPath + orgnName);
				map.put("full_url", relaPath + midPath + orgnName);

				attachment = new Attachment();
				attachment.setFileName(orgnName);
				attachment.setFilePath(midPath + orgnName);

				as.save(attachment);

			} catch (IllegalStateException e) {
				map.put("msg", "上传失败！");
				logger.error("-->文件上传失败！！！");
				e.printStackTrace();
			} catch (IOException e) {
				map.put("msg", "上传失败！");
				logger.error("-->文件上传失败！！！");
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public ResponseEntity<byte[]> download(String fileId, String basePath, String baseURL) throws IOException {

		// 获取文件信息
		Attachment at = as.byId(fileId);

		String midPath = at.getFilePath();
		// File f = new File(baseURL + midPath);
		String fileOrgnName = at.getFileName();

		/* 优雅的处理方式 https://my.oschina.net/songxinqiang/blog/898901 */

		URL url = new URL(baseURL + midPath);

		File file = null;
		try {
			URI uri = url.toURI();

			// URL 方式
			// file = new File(uri);

			// 物理地址方式
			file = new File(basePath + midPath);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(fileOrgnName.getBytes("UTF-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFielName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

	}

	@Override
	public Map<String, Object> uploadFdfs(MultipartFile attach) {

		Map<String, Object> map = new HashMap<String, Object>();

		// 获取文件后缀名
		String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".") + 1);
		FastDFSFile file = null;
		try {
			file = new FastDFSFile(attach.getBytes(), ext);
		} catch (IOException e) {
			e.printStackTrace();
		}
		NameValuePair[] meta_list = new NameValuePair[4];
		meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
		meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
		meta_list[2] = new NameValuePair("fileExt", ext);
		meta_list[3] = new NameValuePair("fileAuthor", "liwc");
		String[] fileResult = FileManager.upload(file, meta_list);

		// 保存附件记录
		Attachment at = new Attachment();
		at.setFileName(fileResult[1]);
		at.setFileGroup(fileResult[0]);
		at.setOrgnName(attach.getOriginalFilename());
		at.setFileSize(String.valueOf(attach.getSize()));
		at.setFileExt(ext);
		at.setFilePath(fileResult[0] + "/" + fileResult[1]);
		as.save(at);

		map.put("filePath", fileResult[0] + "/" + fileResult[1]);

		return map;
	}

	
	
	
	
	@Override
	public ResponseEntity<byte[]> downloadFdfs(String fileId){
		
		Attachment at = as.byId(fileId);
//		Assert.assertNull(at);
		
		String diplayName = at.getOrgnName();
		
		String group = at.getFileGroup();

		String remoteFileName = at.getFileName();

		
		return FileManager.download(group, remoteFileName, diplayName);
		
	}

	@Override
	public int deleteFdfs(String fileId) {
		
		Attachment at = as.byId(fileId);
		
		return FileManager.delete(at.getFileGroup(), at.getFileName());
	}

}
