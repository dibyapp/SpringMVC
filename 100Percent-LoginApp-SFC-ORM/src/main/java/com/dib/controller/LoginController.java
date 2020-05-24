package com.dib.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dib.command.UserCommand;
import com.dib.dto.UserDTO;
import com.dib.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private  LoginService service;
	
	
	@GetMapping("/login.htm")  //to handler initial phase request
	public   String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		//return  lnv
		return "login_form";
	}
	
	@PostMapping("/login.htm")
	public   String  processForm(Map<String,Object> map,@ModelAttribute("userCmd") UserCommand cmd) {
		 UserDTO dto=null;
		 String resultMsg=null;
		// convert cmd to  dto
		 dto=new UserDTO();
		 BeanUtils.copyProperties(cmd, dto);
		//use service
		 resultMsg=service.authenticate(dto);
		 //keep result in model attribute
		 map.put("resultMsg", resultMsg);
		 //return lvn of result page
		 return "login_form";
	}

}