package com.dib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dib.bo.EmployeeBO;
import com.dib.dao.EmployeeDAO;
import com.dib.dto.EmployeeDTO;

@Service("/empService")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDAO dao;

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
