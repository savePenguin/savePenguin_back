package com.cos.photogramstart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//gsn으로 처
@Controller
public class HomeController {
	// 안드로이드 요청(id, pw 받아서 db연동)
		@RequestMapping(value= "/auth/signin", method = {RequestMethod.GET})
		public String androidPage(HttpServletRequest request, Model model) {
			System.out.println("서버에서 안드로이드 접속 요청함");
			try{
					String androidID = request.getParameter("userid");
					String androidPW = request.getParameter("userpw");
					System.out.println("안드로이드에서 받아온 userid : " + androidID);
					System.out.println("안드로이드에서 받아온 userpw : " + androidPW);
					model.addAttribute("android", androidID);
					return "android";
			}catch (Exception e){
					e.printStackTrace();
					return "null";
			}
		}
	}