package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.QRcode;
import com.example.demo.image.createQRImage;

import lombok.Data;
/*
@Data
public class QRcodeUploadDto {
	
	private MultipartFile file;
	private String qrname;
	private String cuptype;
	private String usrname;
	
	public QRcode toEntity(String cuppic, int cuptype, String usrname) {
		
		
		if(cuptype == 1) {
			int qrpoint = 50;
		}else {
			int qrpoint = 100;
		}
		
		
	    String filepath = "/Users/chaehuiseon/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/qr/";
	    String qrpic = filepath;
	    String text = this.qrname + "|" + this.cuptype +  "|" + this.usrname +  "|" + this.qrpoint;
	    
	    try {
	    	createQRImage img = new createQRImage(text,this.qrname, filepath);
	    	
	    }catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return QRcode.builder()
				.qrname(qrname)
				.cuppic(cuppic)
				.cuptype(cuptype)
				.usrname(usrname)
				
				.build();
	
	}
	

}*/

