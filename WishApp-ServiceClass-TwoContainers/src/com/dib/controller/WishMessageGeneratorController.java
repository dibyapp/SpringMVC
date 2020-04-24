package com.dib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dib.services.WishService;

public class WishMessageGeneratorController extends AbstractController {
private WishService service;

	public WishMessageGeneratorController(WishService service) {
	this.service = service;
}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String msg=null;
		msg=service.generateWishMessage();
		
		
		return new ModelAndView("result", "resMg", msg);
	}

}
