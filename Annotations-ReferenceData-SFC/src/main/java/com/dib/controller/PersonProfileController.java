package com.dib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dib.command.PersonCommand;

@Controller
public class PersonProfileController
{
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
	

}
