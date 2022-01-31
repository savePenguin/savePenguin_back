package com.cos.photogramstart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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

	@RequestMapping("/TestImage")
	public @ResponseBody String androidTestWithRequest2(MultipartHttpServletRequest request){

		String map = "temp";
		//등록된 파일 관리하기
		List<MultipartFile> files = request.getFiles("files");

		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getResource());
		}

		return map;
	}
}