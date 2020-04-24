package com.dib.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dib.dto.EmployeeDTO;
import com.dib.service.EmployeeService;

public class EmployeeController extends AbstractController
{
	private EmployeeService service;

	public EmployeeController(EmployeeService service) 
	{
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		List<EmployeeDTO> listDTO=null;
		
		listDTO=service.fetchAllEmployees();
		
		return new ModelAndView("show_emps","listDTO",listDTO);
	}

}
