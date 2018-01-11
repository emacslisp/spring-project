package com.lab.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab.spring.dao.Offer;
import com.lab.spring.service.OffersService;

@Controller
public class HomeController {
	private OffersService offersService;

	/*@RequestMapping("/")
	public ModelAndView showHome(HttpSession session) {
		// this means index.jsp, "xxx".jsp
		
		ModelAndView mv = new ModelAndView("index");
		
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "River");
		
		session.setAttribute("name", "Boris");
		return mv;
	}*/
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	
	@RequestMapping("/")
	public String showHome(Model model) {
		// this means index.jsp, "xxx".jsp
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		
		System.out.println("======== Hello ============");
		
		return "index";
	}
}
