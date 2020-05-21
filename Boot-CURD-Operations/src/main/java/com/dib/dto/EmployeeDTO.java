package com.dib.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;
}
