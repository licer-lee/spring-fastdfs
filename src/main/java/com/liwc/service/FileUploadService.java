package com.liwc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface FileUploadService {

	Map<String, Object> upload(MultipartFile[] file, String path, String relaPath);
	
	Map<String, Object> uploadFdfs(MultipartFile file);
	

	ResponseEntity<byte[]> download(String fileId, String basePath, String baseURL) throws IOException;
	
	ResponseEntity<byte[]> downloadFdfs(String fileId);
	
	
	int deleteFdfs(String fileId);
	
	

	
}
