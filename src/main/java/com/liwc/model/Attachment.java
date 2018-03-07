package com.liwc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ATTACHMENT")
public class Attachment implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3853711593995407361L;



	@Id
	@Column(name = "FILE_ID", length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	String fileId;

	@Column(name = "FILE_NAME", length = 1024)
	String fileName;
	
	@Column(name = "FILE_GROUP", length = 1024)
	String fileGroup;
	
	@Column(name = "ORGN_NAME", length = 1024)
	String orgnName;

	@Column(name = "FILE_SIZE", length = 1024)
	String fileSize;
	
	@Column(name = "FILE_EXT", length = 1024)
	String fileExt;
	
	@Column(name = "FILE_PATH", length = 1024)
	String filePath;



	public String getFileGroup() {
		return fileGroup;
	}

	public void setFileGroup(String fileGroup) {
		this.fileGroup = fileGroup;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

	public String getOrgnName() {
		return orgnName;
	}

	public void setOrgnName(String orgnName) {
		this.orgnName = orgnName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	@Override
	public String toString(){
		return "fileId="+fileId +",fileName="+fileName+",filePath="+filePath;
	}
	
	
}
