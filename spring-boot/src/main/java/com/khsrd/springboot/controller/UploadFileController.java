package com.khsrd.springboot.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {

	
	@GetMapping("/file")
	public String upload() {
		return "upload";
	}
	
	private String UPLOADED_FOLDER ="/images/";
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println(file.getOriginalFilename());
		try {
			byte[] bytes = file.getBytes();
			String fileName = generateFileName(file.getOriginalFilename());
			Path path = Paths.get(UPLOADED_FOLDER+ fileName);
			Files.write(path, bytes);
			model.addAttribute("fileName",fileName);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "upload";
	}
	
	public String generateFileName(String file) {
		String ext = file.substring(file.lastIndexOf("."));
		String fileName = System.currentTimeMillis()+ext;
		System.out.println(fileName);
		return fileName;
	}
	
	
}
