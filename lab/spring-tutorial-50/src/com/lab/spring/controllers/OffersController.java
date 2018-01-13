package com.lab.spring.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lab.spring.dao.Offer;
import com.lab.spring.service.OffersService;

@Controller
public class OffersController {
	
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

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		// this means index.jsp, "xxx".jsp
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		
		System.out.println("======== Hello ============");
		
		return "Home";
	}
	
	@RequestMapping(value="/createoffer")//, method = RequestMethod.POST)
	public String createOffer(Model model) {
		// this means index.jsp, "xxx".jsp
		model.addAttribute("offer",new Offer("name","email","text"));
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		// this means index.jsp, "xxx".jsp
		//System.out.println(offer);
		if(result.hasErrors()) {
			System.out.println("form is not valid");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error);
			}
			
			return "createoffer";
		}
		
		offersService.createOffer(offer);
		
		return "offercreated";
	}
}
