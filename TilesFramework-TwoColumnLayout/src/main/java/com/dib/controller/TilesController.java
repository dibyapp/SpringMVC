package com.dib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {

	@RequestMapping("/welcome.htm")
	public String showForm() 
	{
		return "page1Def";
	}
	@RequestMapping("/products.htm")
	public String showProducts() 
	{
		return "page2Def";
	}
	@RequestMapping("/contact.htm")
	public String showContact() 
	{
		return "page3Def";
	}
	@RequestMapping("/help.htm")
	public String showHelp() 
	{
		return "page4Def";
	}
	
}
