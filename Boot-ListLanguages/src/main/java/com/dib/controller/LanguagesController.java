package com.dib.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dib.service.FetchLanguages;

@Controller
public class LanguagesController {

	@Autowired
	FetchLanguages service;
	
	
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/lang.htm")
	public String getLanguages(Map<String,Object> map) {
		List<String> langList=null;
		langList=service.fetchAllLanguages();
		map.put("langList", langList);
		
		return "show_languages";
	}
}
