package com.lab.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {

	@RequestMapping("/")
	public String showHome() {
		// this means index.jsp, "xxx".jsp
		return "index";
	}
}
