package com.dib.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dib.command.PatientCommand;
import com.dib.dto.PatientDTO;
import com.dib.service.PatientService;
import com.dib.validator.PatientCommandValidator;

@Controller
@SessionAttributes("patCmd")
public class PatientController
{
	@Autowired
	private PatientService service;
	
	@Autowired
	private PatientCommandValidator validator;

	@ModelAttribute("patCmd")
	public PatientCommand getCommand() {
		System.out.println("PatientController.getCommand()");
		return new PatientCommand();
	}
	
	@GetMapping("/corona.htm")
	public String showForm(@ModelAttribute("patCmd")PatientCommand cmd)
	{
		System.out.println("PatientController.showForm()");
		cmd.setLocation("Hyd");
		cmd.setHospital("GHSP");
		
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")
	public String processForm(Map<String,Object> map, @ModelAttribute("patCmd")PatientCommand cmd, BindingResult br) {
		System.out.println("PatientController.processForm()");
		PatientDTO dto=null;
		String result=null;
		
		
		if(validator.supports(PatientCommand.class))
		{
			validator.validate(cmd, br);
			
			if(br.hasErrors())
				return "patient_registration";
		}
		
		
		dto=new PatientDTO();
		System.out.println(cmd);
		BeanUtils.copyProperties(cmd, dto);
		System.out.println(dto);
		result=service.register(dto);
		
		map.put("resMsg", result);

		return "show_result";
	}

}
