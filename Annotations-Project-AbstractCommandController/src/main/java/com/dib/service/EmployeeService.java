package com.dib.service;

import java.util.List;

import com.dib.dto.EmployeeDTO;
import com.dib.dto.EmployeeResultDTO;

public interface EmployeeService 
{
	public List<EmployeeResultDTO> search(EmployeeDTO dto);
}
