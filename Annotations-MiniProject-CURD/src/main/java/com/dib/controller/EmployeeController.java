package com.dib.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dib.command.EmployeeCommand;
import com.dib.dto.EmployeeDTO;
import com.dib.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	private EmployeeService service;

	@RequestMapping("/welcome.htm")
	public String showHome()
	{
		return "home";
	}
	
	@RequestMapping("/list_emps.htm")
	public String showEmps(Map<String,Object> map)
	{
		List<EmployeeDTO> listDTO=null;
		
		listDTO=service.fetchAllEmployees();
		
		map.put("listDTO", listDTO);
		return "show_emps";
	}
	
	@GetMapping("/update.htm")
	public String showEmpUpdateForm(@RequestParam("eno") int empNo, @ModelAttribute("empCmd") EmployeeCommand command) 
	{
		EmployeeDTO dto=null;
		dto=service.fetchEmpByNo(empNo);
		BeanUtils.copyProperties(dto, command);
		
		return "update_form";
	}
	
	@PostMapping("/update.htm")
	public String processEmpUpdation(Map<String,Object> map, @ModelAttribute("empCmd")EmployeeCommand cmd, BindingResult errors) {
		EmployeeDTO dto=null;
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		msg=service.modifyEmpByNo(dto);
		listDTO=service.fetchAllEmployees();
		map.put("resMsg", msg);
		map.put("listDTO", listDTO);
		
		return "show_emps";
	}
	
	@RequestMapping("/delete.htm")
	public String deleteEmployee(Map<String,Object> map, @RequestParam("eno")int no) {
		String msg=null;
		msg=service.removeEmpByNo(no);
		List<EmployeeDTO> listDTO=null;
		listDTO=service.fetchAllEmployees();
		map.put("resMsg",msg);
		map.put("listDTO", listDTO);
		return "show_emps";
	}
	
	@GetMapping("/register.htm")
	public String showEmpInsertForm(@ModelAttribute("empCmd") EmployeeCommand command) 
	{
		
		return "insert_form";
	}
	
	@PostMapping("/register.htm")
	public String processEmpInsert(Map<String,Object> map, @ModelAttribute("empCmd")EmployeeCommand cmd, BindingResult errors) {
		EmployeeDTO dto=null;
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		msg=service.addEmployee(dto);
		listDTO=service.fetchAllEmployees();
		map.put("resMsg", msg);
		map.put("listDTO", listDTO);
		
		return "show_emps";
	}
}
