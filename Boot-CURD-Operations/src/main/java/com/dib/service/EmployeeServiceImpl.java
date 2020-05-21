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
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();

		listBO=dao.getAllEmployees();

		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}

	@Override
	public EmployeeDTO fetchEmpByNo(int eno) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;

		bo=dao.getEmp(eno);

		dto=new EmployeeDTO();

		BeanUtils.copyProperties(bo, dto);

		return dto;
	}

	@Override
	public String modifyEmpByNo(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);

		count=dao.updateEmpByNo(bo);

		return (count==0)?"Failed":"Successful";
	}

	@Override
	public String removeEmpByNo(int no) {
		int count=0;
		count=dao.deleteEmpByNo(no);
		return (count==0)?"Failed":"Successful";
	}

	@Override
	public String addEmployee(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);

		count=dao.insertEmployee(bo);

		return (count==0)?"Failed":"Successful";
	}

}
