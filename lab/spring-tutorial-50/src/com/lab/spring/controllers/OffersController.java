package com.lab.spring.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OffersController {

	/*@RequestMapping("/")
	public ModelAndView showHome(HttpSession session) {
		// this means index.jsp, "xxx".jsp
		
		ModelAndView mv = new ModelAndView("index");
		
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "River");
		
		session.setAttribute("name", "Boris");
		return mv;
	}*/
	
	@RequestMapping("/")
	public String showHome(Model model) {
		// this means index.jsp, "xxx".jsp
		
		model.addAttribute("name", "New Model");
		
		System.out.println("======== Hello ============");
		
		return "index";
	}
}
