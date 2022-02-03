package com.example.demo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dao.QRcodeMapping;
import com.example.demo.dao.QRcodeRepository;
import com.example.demo.entity.QRcode;

import lombok.RequiredArgsConstructor;


//@RequiredArgsConstructor
@RestController
public class QRcodeController {
	
	QRcodeRepository qrcoderepository;

	//private final QRcodeService qrcodeservice;
	
	
	public QRcodeController(QRcodeRepository qrcoderepository) {
		super();
		this.qrcoderepository = qrcoderepository;
	}
	
	
	//qrcode 생성
	@PostMapping("/qrcode")
	public QRcode putQRcode (String qrname, String cuppic , int cuptype, String usrname) {
		System.out.println("QR code 생성 진입");
		QRcode c_QR = new QRcode(qrname,cuppic ,cuptype,usrname);
		System.out.println("QR code 생성 완료");
		return qrcoderepository.save(c_QR);
		
	} 
	
	/*
	@PostMapping("/qrupload")
	public String QRcodeUpload(QRcodeUploadDto qrcodeUploadDto ) {
		
		if(qrcodeUploadDto.getFile().isEmpty()) {
			System.out.println("이미지가 첨부되지 않았습니다.");
		}
		
		String cuppic =  qrcodeservice.QRupload(qrcodeUploadDto );
		
		
		
	}
	*/
	
	//qrcode 생성
	@PostMapping("/qrcodetest")
	public QRcode uploadQRcode2 (String qrname,  @RequestParam("image")MultipartFile image, int cuptype, String usrname) {
		
		System.out.println("QR code 생성 진입");
		//image 업로드 과정
		if(image == null || image.isEmpty()) {
			System.out.println("실패");
		}
		//확장자
		String prefix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".")+1, image.getOriginalFilename().length());
		UUID uuid = UUID.randomUUID(); // uuid
		String filename =  uuid+"_"+ image.getOriginalFilename() + "." + prefix;
		System.out.println("이미지 파일 이름 : "+ filename);
		String filepath = "/Users/chaehuiseon/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/cup/"+usrname+"/";
		
		//파일 없으면 만들
		File folder = new File(filepath);
		if(!folder.isDirectory()) {
			folder.mkdirs();
		}
		
		//컵이미지 저장
		File dest = new File(filepath+filename);
		try {
			image.transferTo(dest);
			System.out.println("완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
		String cuppic = filename;
		
		//QR 생성
		QRcode c_QR = new QRcode(qrname,cuppic ,cuptype,usrname);
		System.out.println("QR code 생성 완료");
		return qrcoderepository.save(c_QR);
		
	} 
	
	//usrname(유저 이름) 을 통해 등록해 놓은 QR정보들을 조회한다.
	@GetMapping("/qrcode/get")
	public List<QRcode> getQRcode(String usrname) {
		return qrcoderepository.findByUsrname(usrname);
	}
	
	
	/*
	@GetMapping("/qrcode/get/reader")
	public List<QRcodeMapping> getReaderQRcode(String usrname, String qrname, int id ) {
		List<QRcodeMapping> tmp = qrcoderepository. findByUsrnameAndQrnameAndId(usrname, qrname, id);
		System.out.println(tmp.toString());
		return tmp;
		
	}
	*/
	


	
	
	/*
	@GetMapping("/qrcode/in")
	public String getQRcode(String usrname) {
		List<QRcode> tmp = qrcoderepository.findByUsrname(usrname);
		return "succes";
	}
	*/
	
	
	
	//{"qrinfo":[{"qrname":"리유저블,dddd","cuptype":1,"qrpoint":50,"usrname":"jhhhh,chaehyi"}]}
	//{"qrinfo":[{"qrname":"50","cuptype":1,"qrpoint":50,"usrname":"채희선"}]}
	@PutMapping("/qrcode/reader")
	public void readQRcode(String info) {
		
		//String[] ArraysStr = info.split("|");
		//QRcode update = new QRcode( qrname, cuptype, int qrpoint, String usrname)
		
	}
	



	
	

}
