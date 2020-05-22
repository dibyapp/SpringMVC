package com.dib.service;

import java.util.List;

import com.dib.dto.EmployeeDTO;

public interface EmployeeService {

	public int getPagesCount(int size);
	public List<EmployeeDTO> getPageData(int pageNo, int pageSize);
	
}
