package com.example.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dao.QRcodeRepository;
import com.example.demo.entity.QRcode;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

/*
@RequiredArgsConstructor
@Service
public class QRcodeService {

	private final QRcodeRepository qrcoderepository;
	
	private String uploadFolder = "/Users/chaehuiseon/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/cup/";
	
	
	
	@Transactional
	public String QRupload(QRcodeUploadDto qrcodeUploadDto) {
		
		UUID uuid = UUID.randomUUID(); // uuid
		String cupImageFileName = uuid+"_"+qrcodeUploadDto.getFile().getOriginalFilename(); // 1.jpg
		System.out.println("이미지 파일이름 : "+cupImageFileName);
		
		Path imageFilePath = Paths.get(uploadFolder+cupImageFileName);
		
		// 통신, I/O -> 예외가 발생할 수 있다.
		try {
			Files.write(imageFilePath, qrcodeUploadDto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cupImageFileName;
		
		
	}
	

	
}
*/
