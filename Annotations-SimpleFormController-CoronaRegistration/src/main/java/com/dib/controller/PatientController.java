package com.dib.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dib.command.PatientCommand;
import com.dib.dto.PatientDTO;
import com.dib.service.PatientService;

@Controller
public class PatientController
{
	@Autowired
	private PatientService service;

	@GetMapping("/corona.htm")
	public String showForm(@ModelAttribute("patCmd")PatientCommand cmd)
	{
		cmd.setLocation("Hyd");
		cmd.setHospital("GHSP");
		
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")
	public String processForm(Map<String,Object> map, @ModelAttribute("patCmd")PatientCommand cmd, BindingResult br) {
		PatientDTO dto=null;
		String result=null;
		dto=new PatientDTO();
		System.out.println(cmd);
		BeanUtils.copyProperties(cmd, dto);
		System.out.println(dto);
		result=service.register(dto);
		
		map.put("resMsg", result);

		return "show_result";
	}

}
