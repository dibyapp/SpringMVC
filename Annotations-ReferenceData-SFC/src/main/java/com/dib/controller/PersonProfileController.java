package com.dib.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dib.command.PersonCommand;
import com.dib.validator.Validator;

@Controller
public class PersonProfileController
{
	@Autowired
	private Validator validator;
	
	@ModelAttribute("gendersList")
	public List<String> populateGender()
	{
		List<String> list=new ArrayList<String>();
		list.add("male");
		list.add("female");
		return list;
	}
	
	@ModelAttribute("hobiesList")
	public List<String> populateHobies()
	{
		List<String> list=new ArrayList<String>();
		list.add("meditation");
		list.add("workout");
		list.add("music");
		list.add("travelling");
		return list;
	}
	
	@ModelAttribute("coursesList")
	public List<String> populateCourses()
	{
		List<String> list=new ArrayList<String>();
		list.add("java");
		list.add("python");
		list.add("android");
		list.add("angular");
		list.add("html");
		list.add("jquery");
		return list;
	}
	
	@ModelAttribute("qualificationsList")
	public List<String> populateQualification()
	{
		List<String> list=new ArrayList<String>();
		list.add("B.Tech");
		list.add("MCA");
		list.add("MBA");
		list.add("MBBS");
		list.add("B.Sc");
		list.add("M.Tech");
		return list;
	}
	
	@GetMapping("/register.htm")
	public String showForm(@ModelAttribute("perCmd")PersonCommand cmd)
	{
		return "person_register";
	}
	
	@PostMapping("/register.htm")
	public String processForm(Map<String,Object>map,@ModelAttribute("perCmd")PersonCommand cmd,BindingResult errors) {
		if(validator.supports(cmd.getClass())) {
			validator.validate(cmd, errors);
			if(errors.hasErrors()) {
				return "person_register";
			}
		}
		return "show_result";
	}
}
