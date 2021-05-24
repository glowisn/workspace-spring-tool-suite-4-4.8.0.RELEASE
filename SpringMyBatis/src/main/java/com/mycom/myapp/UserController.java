package com.mycom.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.myapp.user.UserServiceImpl;
import com.mycom.myapp.user.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/login")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@RequestMapping(value = "/login")
	public String login(String t,Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/loginOK",method=RequestMethod.POST)
	public String loginCheck(HttpSession session,UserVO vo) {
		String returnURL ="";
		if(session.getAttribute("login")!= null) {
			session.removeAttribute("login");
		}
		
		UserVO loginvo = service.getUser(vo);
		if(loginvo != null) {
			System.out.println("LOGIN SUCCESS!");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/board/list";
		}else {
			System.out.println("LOGIN FAILED!");
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	

}
