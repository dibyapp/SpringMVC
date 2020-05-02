package com.dib.service;

import java.util.List;

import com.dib.dto.EmployeeDTO;

public interface EmployeeService 
{
	public List<EmployeeDTO> fetchAllEmployees();
	public EmployeeDTO fetchEmpByNo(int eno);
	public String modifyEmpByNo(EmployeeDTO dto);
	public String removeEmpByNo(int no);
	public String addEmployee(EmployeeDTO dto);
}
