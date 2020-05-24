package com.dib.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dib.bo.UserBO;
import com.dib.dao.LoginDAO;
import com.dib.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "dsTxMgmr")
	public String authenticate(UserDTO dto) {
		UserBO bo=null;
		int count=0;
		//convert  dto to bo
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use dAO
		count=dao.validate(bo);
		
		return count==0?"InValid Credentials ": "Valid Credentials";
	}

}
