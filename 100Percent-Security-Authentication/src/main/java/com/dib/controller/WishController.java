package com.dib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dib.service.WishMessageService;

@Controller
public class WishController {
	
	@Autowired
	private WishMessageService service;
	
	@RequestMapping("/home.htm")
	public String showHome() 
	{
		return "welcome";
	}
	
	@RequestMapping("/wish.htm")
	public ModelAndView process() 
	{
		String msg=null;
		msg=service.getWishMessage();
		return new ModelAndView("result", "wMsg", msg);
	}
}
