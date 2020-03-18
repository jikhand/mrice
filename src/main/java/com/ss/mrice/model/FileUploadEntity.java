package com.ss.mrice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_upload")
public class FileUploadEntity {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileId;
	private String fileName;
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "FileUploadEntity [fileId=" + fileId + ", fileName=" + fileName + "]";
	}
	
}
