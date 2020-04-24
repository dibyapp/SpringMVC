package com.dib.dao;

import java.util.List;

import com.dib.bo.EmployeeBO;
import com.dib.bo.EmployeeResultBO;

public interface EmployeeDAO 
{
public List<EmployeeResultBO> find(EmployeeBO bo);
}
