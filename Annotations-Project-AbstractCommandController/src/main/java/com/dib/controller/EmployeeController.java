package com.dib.controller;

import java.net.BindException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dib.command.EmployeeCommand;
import com.dib.dto.EmployeeDTO;
import com.dib.dto.EmployeeResultDTO;
import com.dib.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	private EmployeeService service;

	@RequestMapping("welcome.htm")
	public String showHome()
	{
		return "search_employee";
	}
	
	@RequestMapping("search_emps.htm")
	public String searchEmps(Map<String,Object> map, @ModelAttribute EmployeeCommand cmd, BindException be)
	{
		EmployeeDTO dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		dto=new EmployeeDTO();
		
		BeanUtils.copyProperties(cmd, dto);
		
		listRDTO=service.search(dto);
		map.put("listRDTO", listRDTO);
		
		return "show_results";
	}

}
