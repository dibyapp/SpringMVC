package com.dib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dib.bo.EmployeeBO;
import com.dib.dao.EmployeeDAO;
import com.dib.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService 
{
	private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) 
	{
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> fetchAllEmployees() 
	{
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		
		listBO=dao.getAllEmployees();
		
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}

}
