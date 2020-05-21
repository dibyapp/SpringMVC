package com.dib.dao;

import java.util.List;

import com.dib.bo.EmployeeBO;

public interface EmployeeDAO 
{
	public List<EmployeeBO> getAllEmployees();
	public EmployeeBO getEmp(int eno);
	public int updateEmpByNo(EmployeeBO bo);
	public int deleteEmpByNo(int no);
	public int insertEmployee(EmployeeBO bo);
}
