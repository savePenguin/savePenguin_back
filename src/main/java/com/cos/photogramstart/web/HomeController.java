package com.cos.photogramstart.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

//gsn으로 처
@Controller
public class HomeController {
	// 안드로이드 요청(id, pw 받아서 db연동)
	@RequestMapping(value = "/auth/signin",
			method = {RequestMethod.GET, RequestMethod.POST},
			produces = "application/json;charset=utf-8")
	@ResponseBody
	public String androidPage(HttpServletRequest request, Model model) {

		System.out.println("서버에서 안드로이드 접속 요청함");


		Enumeration params = request.getHeaderNames();
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.println(name + " : " + request.getParameter(name));
		}

		try {
			String androidID = request.getParameter("userid");
			String androidPW = request.getParameter("userpw");
			System.out.println("안드로이드에서 받아온 userid : " + androidID);
			System.out.println("안드로이드에서 받아온 userpw : " + androidPW);
			model.addAttribute("android", androidID);
			return "android";
		} catch (Exception e) {
			e.printStackTrace();
			return "null";
		}
	}

	@RequestMapping("/TestLogin")
	public void androidTestWithRequest(HttpServletRequest request){
		System.out.println(request.getParameter("userid"));
		System.out.println(request.getParameter("userpw"));
	}
/*

	@RequestMapping("/TestImage")
	public @ResponseBody void androidTestWithRequest2(@RequestParam String userid,
														@RequestParam String qrname,
														@RequestParam String cuptype,
														@RequestParam  file){

		//등록된 파일 관리하기
		System.out.println(userid);
		System.out.println(qrname);
		System.out.println(cuptype);
		ResponseBody cur = file;

		System.out.println(cur.getName());
		System.out.println(cur.getOriginalFilename());
		try {
			System.out.println(cur.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
*/




	@RequestMapping("/TestUpdateQR")
	public void androidTestWithRequest3(HttpServletRequest request){
		System.out.println(request.getParameter("userid"));
		System.out.println(request.getParameter("userpw"));
	}



	//qrcode 생성
	@PostMapping("/qrcodetest")
	public void uploadQRcode3 (MultipartHttpServletRequest request) {

		String qrname = request.getParameter("qrname");
		String usrname = request.getParameter("userid");
		int cuptype = Integer.parseInt(request.getParameter("cuptype"));
		System.out.println("qrname = " + qrname);
		System.out.println("usrname = " + usrname);
		System.out.println("cuptype = " + cuptype);

		MultipartFile image =  request.getFile("cuppic");



		String userid = request.getParameter("userid");
		try {
			byte[] data = image.getBytes();
			//byte[] data2 = image2.getBytes();
			//byte[] data3 = image3.getBytes();
			System.out.println(Arrays.toString(data));
			//System.out.println(Arrays.toString(data2));
			//System.out.println(Arrays.toString(data3));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("QR code 생성 진입");
		//image 업로드 과정
		if (image == null || image.isEmpty()) {
			System.out.println("실패");
			try {
				byte[] data = image.getBytes();
				System.out.println(Arrays.toString(data));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("성성공");
		}

	}

}