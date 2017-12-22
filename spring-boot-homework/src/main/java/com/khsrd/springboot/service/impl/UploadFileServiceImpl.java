package com.khsrd.springboot.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khsrd.springboot.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {
	private String UPLOADED_FOLDER ="/images/";
	@Override
	public String uploadFile(MultipartFile file) {
		
		File f = new File("/images");
		if(!f.exists()) {
			f.mkdirs();
		}
		// TODO Auto-generated method stub
		System.out.println(file.getOriginalFilename());
		try {
			byte[] bytes = file.getBytes();
			String fileName = generateFileName(file.getOriginalFilename());
			Path path = Paths.get(UPLOADED_FOLDER+ fileName);
			Files.write(path, bytes);
			return "/resource/"+fileName;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public String generateFileName(String file) {
		String ext = file.substring(file.lastIndexOf("."));
		String fileName = System.currentTimeMillis()+ext;
		System.out.println(fileName);
		return fileName;
	}

}
