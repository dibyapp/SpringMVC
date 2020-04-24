package com.dib.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dib.bo.PatientBO;
import com.dib.dao.PatientDAO;
import com.dib.dto.PatientDTO;

@Service
public class PateintServiceImpl implements PatientService {

	@Autowired
	private PatientDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String register(PatientDTO dto) {
		
		System.out.println("Service"+dto);
		int count=0;
		PatientBO bo=null;
		bo=new PatientBO();
		
		BeanUtils.copyProperties(dto, bo);
		count=dao.insert(bo);
//		return count==0?"Failed":"Success";
		
		System.out.println(count);
		
		if(count==0)
		{
			return "Failed";
		}
		else
		{
			return "Success";
		}
	}

}
