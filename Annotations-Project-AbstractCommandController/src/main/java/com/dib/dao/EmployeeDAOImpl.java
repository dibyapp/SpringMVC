package com.dib.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dib.bo.EmployeeBO;
import com.dib.bo.EmployeeResultBO;

@Repository("/empDAO")
public class EmployeeDAOImpl implements EmployeeDAO
{
	private static final String QUERY="(SELECT ENO,ENAME,JOB,SALARY,DEPTNO FROM EMP WHERE (ENO=?) OR (ENAME LIKE ?) OR (JOB LIKE ?) OR (SALARY=?))";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<EmployeeResultBO> find(EmployeeBO bo) 
	{
		List<EmployeeResultBO> listRBO=null;
		listRBO=jt.query(QUERY, rs->{
					List<EmployeeResultBO> listRBO1=null;
					EmployeeResultBO rbo=null;
					listRBO1=new ArrayList<EmployeeResultBO>();
					while(rs.next())
					{
						rbo= new EmployeeResultBO();
						rbo.setEmpNo(rs.getInt(1));
						rbo.setEname(rs.getString(2));
						rbo.setJob(rs.getString(3));
						rbo.setSalary(rs.getFloat(4));
						rbo.setDeptNo(rs.getInt(5));
						
						listRBO1.add(rbo);
					}
					
					return listRBO1;
					
				},bo.getEmpNo(),bo.getEname(),bo.getJob(),bo.getSalary());
		
		return listRBO;
	}
}
