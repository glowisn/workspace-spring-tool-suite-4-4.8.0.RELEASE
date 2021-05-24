package com.mycom.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.myapp.complain.ComplainVO;
import com.mycom.myapp.complain.ComplainServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/complain")
public class ComplainController {
	
	@Autowired
	ComplainServiceImpl service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", service.getComplainList());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOK(ComplainVO vo) {
		if(service.insertComplain(vo) == 0)
			System.out.println("데이터 추가 실패!");
		else
			System.out.println("데이터 추가 성공!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		ComplainVO complainVO = service.getComplain(id);
		model.addAttribute("u", complainVO);
		return "editform";
	}
	
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOK(ComplainVO vo) {
		if(service.updateComplain(vo) == 0)
			System.out.println("데이터 수정 실패!");
		else
			System.out.println("데이터 수정 성공!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id) {
		if(service.deleteComplain(id) == 0)
			System.out.println("데이터 삭제 실패!");
		else
			System.out.println("데이터 삭제 성공!");
		return "redirect:../list";
	}
	
	@RequestMapping(value = "/login")
	public String login(String t,Model model) {
		return "login";
	}
}
