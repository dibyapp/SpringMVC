package com.dib.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dib.dto.EmployeeDTO;
import com.dib.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	private EmployeeService service;

	@RequestMapping("welcome.htm")
	public String showHome()
	{
		return "home";
	}
	
	@RequestMapping("list_emps.htm")
	public String showEmps(Map<String,Object> map)
	{
		List<EmployeeDTO> listDTO=null;
		
		listDTO=service.fetchAllEmployees();
		
		map.put("listDTO", listDTO);
		return "show_emps";
	}

}
