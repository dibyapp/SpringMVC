package com.dib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dib.command.StudentCommand;

@Controller
public class StudentController {

	@RequestMapping("/register.htm")
	public String showForm(@ModelAttribute("stuCmd") StudentCommand cmd) {
	
		
		return "show_form";
	}
	
}
