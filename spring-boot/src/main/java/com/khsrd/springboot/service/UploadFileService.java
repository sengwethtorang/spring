package com.khsrd.springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	public String uploadFile(MultipartFile file);
}
