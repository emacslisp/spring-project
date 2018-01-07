package com.lab.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {

	@RequestMapping("/")
	public String showHome(HttpSession session) {
		// this means index.jsp, "xxx".jsp
		
		session.setAttribute("name", "Boris");
		return "index";
	}
}
