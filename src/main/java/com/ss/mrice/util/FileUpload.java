package com.ss.mrice.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class FileUpload {
	
	private static String UPLOADED_FOLDER = "E://images//";
	
	public void saveUploadFiles(List<MultipartFile> files) throws IOException {
		for(MultipartFile file:files) {
			if(file.isEmpty()) {
				continue; //next pls
			}
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}
}
